package com.surfspotcheck.surfspotcheck.Models;

/**
 * Created by chibs on 03/12/17.
 */

public class LocationMyModel
{
    public LocationMyModel()
    {

    }

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



}
