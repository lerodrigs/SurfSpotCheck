package com.surfspotcheck.surfspotcheck.ClimaTempoApi;

import android.os.AsyncTask;

import com.surfspotcheck.surfspotcheck.Controllers.ConverterUtils;
import com.surfspotcheck.surfspotcheck.Models.ClimaTempo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Result;

public class  ClimaTempoRequest
{
    public static List<ClimaTempo> getListToday(Date date)
    {
        List<ClimaTempo> list = new ArrayList<ClimaTempo>();

        try
        {

            HttpURLConnection connection;
            URL url = null;

            if(date == null)
            {
                url = new URL("https://api.hgbrasil.com/weather/?format=json&woeid=455952");

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(15000);
                connection.setConnectTimeout(15000);
                connection.connect();

                if(connection.getResponseCode() == HttpURLConnection.HTTP_BAD_GATEWAY)
                {
                    return null;
                }

                String strInput = ConverterUtils.InputStreamToString(connection.getInputStream());
                JSONObject jsonObject = new JSONObject(strInput);

                list = ConverterUtils.JObjectToClimaTempo(jsonObject);
            }
            else
            {

            }

            return list;
        }
        catch (Exception e) { return null; }
    }
}


