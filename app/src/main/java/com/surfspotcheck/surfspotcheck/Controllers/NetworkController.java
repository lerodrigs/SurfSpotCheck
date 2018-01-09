package com.surfspotcheck.surfspotcheck.Controllers;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import static android.content.Context.WIFI_SERVICE;

public class NetworkController
{
    Activity context;

    public NetworkController(Activity context)
    {
        this.context = context;
    }

    public boolean isConnected()
    {
        try
        {
            if(getTypeConnection() > 0 )
                return true;
            else
                return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    // 1 -> WIFI.
    // 2 -> MOBILE.
    // 0 -> OFF
    public byte getTypeConnection()
    {
        try
        {
            byte connection = 0;

            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

            for (NetworkInfo netInfo : networkInfos)
            {
                if(netInfo.getTypeName().equalsIgnoreCase("WIFI")){
                    if(netInfo.isConnected())
                        connection =  1;
                }
                else if(netInfo.getTypeName().equalsIgnoreCase("MOBILE"))
                {
                    if(netInfo.isConnected())
                        connection = 2;
                }
            }

            return connection;
        }
        catch (Exception e )
        {
            return 0;
        }
    }

    public String getIpAddress()
    {
        try
        {
            String ip_address = null;

            if(isConnected())
            {
                if(getTypeConnection() == 1)
                {
                    WifiManager wifiMgr = (WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
                    WifiInfo wifiInfo = wifiMgr.getConnectionInfo();

                    int ip = wifiInfo.getIpAddress();
                    ip_address = Formatter.formatIpAddress(ip);
                }
                else
                {
                    List<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

                    for(NetworkInterface networkInterface : networkInterfaces)
                    {
                        List<InetAddress> inetAddresses = Collections.list(networkInterface.getInetAddresses());

                        for (InetAddress inetAddress : inetAddresses)
                        {
                            if(!inetAddress.isLoopbackAddress())
                            {
                                ip_address = inetAddress.getHostAddress();
                            }
                        }
                    }
                }
            }

            return ip_address;
        }
        catch (Exception e )
        {
            return null;
        }
    }
}
