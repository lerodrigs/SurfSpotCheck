package com.surfspotcheck.surfspotcheck.Listeners;

import android.app.Activity;
import android.app.PendingIntent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.surfspotcheck.surfspotcheck.Controllers.LocationController;
import com.surfspotcheck.surfspotcheck.Controllers.SharedPreferencesController;


public class MyLocationListener implements LocationListener
{
    Activity context;
    SharedPreferencesController sharedPreferencesController;

    public MyLocationListener(Activity _context)
    {
        context = _context;
        sharedPreferencesController = new SharedPreferencesController(context);
    }

    public LocationListener getLocationListener()
    {
        return this;
    }

    @Override
    public void onLocationChanged(Location location)
    {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
        String teste = null;
    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }
}
