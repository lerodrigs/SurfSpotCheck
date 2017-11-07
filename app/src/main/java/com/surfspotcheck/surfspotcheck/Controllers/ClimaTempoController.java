package com.surfspotcheck.surfspotcheck.Controllers;

import com.surfspotcheck.surfspotcheck.ClimaTempoApi.ClimaTempoRequest;
import com.surfspotcheck.surfspotcheck.Models.ClimaTempo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ClimaTempoController {

    public List<ClimaTempo> getToday(Date date)
    {
        try
        {
            return ClimaTempoRequest.getListToday(date);
        }
        catch (Exception e){ return null; }
    }
}
