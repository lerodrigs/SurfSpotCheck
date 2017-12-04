package com.surfspotcheck.surfspotcheck.Controllers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.Listeners.MyLocationListener;
import com.surfspotcheck.surfspotcheck.Models.LocationMyModel;
import com.surfspotcheck.surfspotcheck.R;
import com.surfspotcheck.surfspotcheck.SQLite.LocationRepository;

import static android.content.Context.LOCATION_SERVICE;

public class LocationController
{
    Activity context;
    SharedPreferences sharedPreferences;
    LocationManager locationManager;
    LocationRepository locationRepository;

    int LOCATION_REQUISTION = 1;

    //Retorna ou salva a ultima localização do usuário.

    //keys
    // -> lat = latitude
    // -> lon = longitude

    public LocationController (Activity _context )
    {
        this.context = _context;
        this.locationRepository = new LocationRepository();
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
    }

    public Boolean IsEnable()
    {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public void setLastLocation(Location location)
    {
        try
        {
            LocationMyModel locationMyModel = new LocationMyModel();

            locationMyModel.setLatitude(Double.toString(location.getLatitude()));
            locationMyModel.setLongitude(Double.toString(location.getLongitude()));
            locationMyModel.setProviderName(location.getProvider());

            locationRepository.insertLastLocation(locationMyModel);
        }
        catch (Exception e){ e.printStackTrace();}
    }

    public LocationMyModel getLastLocation()
    {
        try
        {
            return locationRepository.getLastLocation();
        }
        catch (Exception e )
        {
            return null;
        }
    }

    public LocationManager getLocationManager()
    {
        return this.locationManager;
    }

    public void locationVerification()
    {
        try
        {
            if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Criteria criteria = new Criteria();

                MyLocationListener myLocationListener = new MyLocationListener(context);
                LocationListener locationListener = myLocationListener.getLocationListener();

                String providerName = locationManager.getBestProvider(criteria, true);

                if (providerName.equals("passive"))
                {
                    providerName = "network";
                }

                if (!IsEnable()) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context, R.style.CustomDialogTheme);

                    alertBuilder.setTitle("Localização inativa!");
                    alertBuilder.setMessage("Ligue sua localização para continuar");

                    alertBuilder.setPositiveButton("Ativar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent startLocation = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            context.startActivityForResult(startLocation, LOCATION_REQUISTION);
                        }
                    });

                    AlertDialog dialog = alertBuilder.create();
                    dialog.show();
                }

                locationManager.requestLocationUpdates(providerName, 1, 1, locationListener);
                Location location = locationManager.getLastKnownLocation(providerName);

                if(location != null)
                {
                    setLastLocation(location);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
