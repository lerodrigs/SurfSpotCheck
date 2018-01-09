package com.surfspotcheck.surfspotcheck.Models;

import java.util.Date;

/**
 * Created by chibs on 03/12/17.
 */

public class LocationMyModel
{
    public LocationMyModel()
    {

    }

    public Date data_hora;
    public String ip_adress;
    public String longitude;
    public String latitude;
    public String providerName;

    public void setIpAdress(String ip_adress)
    {
        this.ip_adress = ip_adress;
    }

    public String getIpAdress()
    {
        return this.ip_adress;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {
        return this.longitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    public String getProviderName()
    {
        return this.providerName;
    }

    public void setData_hora(Date _data_hora)
    {
        this.data_hora = _data_hora;
    }

    public Date getData_hora()
    {
        return this.data_hora;
    }

}
