package com.surfspotcheck.surfspotcheck.Controllers;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
//import com.google.android.gms.location.LocationListener;
import android.location.LocationListener;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.surfspotcheck.surfspotcheck.Listeners.MyLocationListener;
import com.surfspotcheck.surfspotcheck.Models.LocationMyModel;
import com.surfspotcheck.surfspotcheck.R;
import com.surfspotcheck.surfspotcheck.SQLite.LocationRepository;

import java.util.Calendar;
import java.util.Date;

import static android.content.Context.LOCATION_SERVICE;

public class LocationController
{
    Activity context;
    SharedPreferences sharedPreferences;
    LocationManager locationManager;
    LocationRepository locationRepository;
    NetworkController networkController;

    int LOCATION_REQUISTION = 1;

    public LocationController (Activity _context)
    {
        this.context = _context;
        this.locationRepository = new LocationRepository();
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        this.networkController = new NetworkController(context);
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

            Calendar calendar = Calendar.getInstance();
            Date dataHora = calendar.getTime();

            locationMyModel.setLatitude(Double.toString(location.getLatitude()));
            locationMyModel.setLongitude(Double.toString(location.getLongitude()));
            locationMyModel.setProviderName(location.getProvider());
            locationMyModel.setIpAdress(networkController.getIpAddress());
            locationMyModel.setData_hora(dataHora);

            locationRepository.insertLastLocation(locationMyModel);
        }
        catch (Exception e){ e.printStackTrace();}
    }

    public LocationMyModel getLastLocation()
    {
        try
        {
            LocationMyModel locationMyModel = new LocationMyModel();
            Location location = requestLocation();

            if(location == null)
            {
                //locationMyModel = locationRepository.getLastLocation(); -- pegava a ultima localização gravada no dispositivo.

                locationMyModel.setIpAdress(networkController.getIpAddress());
                locationMyModel.setProviderName("network");
                locationMyModel.setData_hora(new Date());
                locationMyModel.setLongitude(null);
                locationMyModel.setLatitude(null);
            }
            else
            {
                locationMyModel.setLatitude(String.valueOf(location.getLatitude()));
                locationMyModel.setLongitude(String.valueOf(location.getLongitude()));
                locationMyModel.setProviderName(location.getProvider());
                locationMyModel.setData_hora(new Date());
                locationMyModel.setIpAdress(networkController.getIpAddress());
            }

            return locationMyModel;
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

    public Location requestLocation()
    {
        try
        {
            Location location;

            if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }

            if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);
            }

            MyLocationListener myLocationListener = new MyLocationListener(context);
            LocationListener locationListener = myLocationListener.getLocationListener();

            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            String providerName;

            if (!IsEnable())
            {
                providerName = locationManager.NETWORK_PROVIDER;

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
            else
                providerName = locationManager.GPS_PROVIDER;

            locationManager.requestLocationUpdates(providerName, 2000, 0, locationListener);
            location = locationManager.getLastKnownLocation(providerName);

            if(location != null)
            {
                setLastLocation(location);
            }

            return location;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
