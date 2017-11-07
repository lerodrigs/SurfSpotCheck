package com.surfspotcheck.surfspotcheck.Controllers;

import com.surfspotcheck.surfspotcheck.Models.ClimaTempo;
import com.surfspotcheck.surfspotcheck.Models.Mare;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ConverterUtils
{
    public static String InputStreamToString(InputStream input)
    {
        StringBuffer stringBuffer = new StringBuffer();

        try
        {
            BufferedReader bufferedReader;
            String linha;

            bufferedReader = new BufferedReader(new InputStreamReader(input, "UTF-8"));

            while ((linha = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(linha);
            }
        }
        catch (Exception e) { }

        return stringBuffer.toString();
    }

    public static List<ClimaTempo> JObjectToClimaTempo(JSONObject object)
    {
        List<ClimaTempo> list = new ArrayList<ClimaTempo>();
        ClimaTempo climaTempo = new ClimaTempo();
        Calendar calendar = Calendar.getInstance();

        try
        {
            JSONObject result = object.getJSONObject("results");
            JSONArray forecast = result.getJSONArray("forecast");

            int ano = Integer.parseInt(result.getString("date").substring(6,10)); //ano
            int mes = Integer.parseInt(result.getString("date").substring(3,5)) -1; //mes
            int dia = Integer.parseInt(result.getString("date").substring(0,2));//dia

            calendar.set(ano, mes, dia);
            Date date = calendar.getTime();

            climaTempo.setData(date);
            climaTempo.setVelocidadeVento(result.getString("wind_speedy"));
            climaTempo.setDescricao(result.getString("description"));
            climaTempo.setCidade(result.getString("city_name"));
            climaTempo.setTemp(Integer.parseInt(result.getString("temp")));
            climaTempo.setConditionSlug(result.getString("condition_slug"));
            climaTempo.setUmidade(Integer.parseInt(result.getString("humidity")));

            list.add(climaTempo);

            for (int i = 0; i < forecast.length(); i++)
            {
                JSONObject jObject = forecast.getJSONObject(i);

                mes = Integer.parseInt(jObject.getString("date").substring(3,5)) -1; //mes
                dia = Integer.parseInt(jObject.getString("date").substring(0,2));//dia

                calendar.set(ano, mes, dia);
                Date dateArray = calendar.getTime();

                // não repete a data de hoje.
                if(!dateArray.equals(date))
                {
                    ClimaTempo climaTempoArray = new ClimaTempo();

                    climaTempoArray.setData(dateArray);
                    climaTempoArray.setDiaSemana(jObject.getString("weekday"));
                    climaTempoArray.setTempMax(Integer.parseInt(jObject.getString("max")));
                    climaTempoArray.setTempMin(Integer.parseInt(jObject.getString("min")));
                    climaTempoArray.setDescricao(jObject.getString("description"));
                    climaTempoArray.setCondition(jObject.getString("condition"));

                    list.add(climaTempoArray);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }

}
