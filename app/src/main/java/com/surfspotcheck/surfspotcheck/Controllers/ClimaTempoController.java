package com.surfspotcheck.surfspotcheck.Controllers;

import android.app.Activity;
import android.location.Location;
import android.test.ActivityUnitTestCase;

import com.surfspotcheck.surfspotcheck.ClimaTempoApi.ClimaTempoRequest;
import com.surfspotcheck.surfspotcheck.Listeners.MyLocationListener;
import com.surfspotcheck.surfspotcheck.Models.ClimaTempo;
import com.surfspotcheck.surfspotcheck.Models.LocationMyModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClimaTempoController
{
    Activity context;

    public ClimaTempoController(Activity context)
    {
        this.context = context;
    }

    public List<ClimaTempo> getToday(Date date, LocationMyModel location)
    {
        try
        {
            return ClimaTempoRequest.getListToday(date, location.getIpAdress(), location.getLatitude(), location.getLatitude());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
