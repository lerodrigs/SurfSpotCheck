package com.surfspotcheck.surfspotcheck.Controllers;

import android.app.Activity;
import android.location.LocationManager;

import static android.content.Context.LOCATION_SERVICE;

public class LocationController
{
    Activity context;

    public LocationController (Activity _context )
    {
        this.context = _context;
    }

    public Boolean IsEnable()
    {
        LocationManager locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        return locationManager.isProviderEnabled(context.LOCATION_SERVICE);
    }

    public void Enable()
    {

    }

    public void Disable()
    {

    }

    public void setLatitude()
    {

    }

    public void setLongitude()
    {

    }

    public String getLatitude(){
        return null;
    }

    public String getLongitude()
    {
        //LocationManager locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        return null;
    }
}
