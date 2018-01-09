package com.surfspotcheck.surfspotcheck.SQLite;

import android.app.VoiceInteractor;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.location.Location;

import com.surfspotcheck.surfspotcheck.Activities.Main;
import com.surfspotcheck.surfspotcheck.Activities.SplashScreen;
import com.surfspotcheck.surfspotcheck.Models.LocationMyModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by chibs on 03/12/17.
 */

public class LocationRepository
{
    SQLiteDatabase db_ssc;
    DbSurfSpotCheck dbSurfSpotCheck;

    public LocationRepository()
    {
        this.dbSurfSpotCheck = new DbSurfSpotCheck(SplashScreen.context);
    }

    public void insertLastLocation(LocationMyModel locationmMyModel)
    {
        try
        {
            db_ssc = dbSurfSpotCheck.getWritableDatabase();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();

            String command = "INSERT INTO LOCALIZACOES " +
                    "(" +
                    "   DATA_HORA, LATITUDE, LONGITUDE, PROVIDER_NAME" +
                    ")" +
                    "VALUES" +
                    "(" +
                    "'"+dateFormat.format(date) + "', "+
                    "'"+locationmMyModel.getLatitude() + "', "+
                    "'"+locationmMyModel.getLongitude() + "', "+
                    "'"+locationmMyModel.getProviderName() +"'" +
                    ");";

            db_ssc.execSQL(command);
            db_ssc.close();
        }
        catch (SQLiteException e )
        {
            db_ssc.endTransaction();
        }
    }

    public LocationMyModel getLastLocation()
    {
        try
        {
            LocationMyModel locationMyModel = new LocationMyModel();
            db_ssc = dbSurfSpotCheck.getReadableDatabase();

            Cursor cursor = db_ssc.rawQuery("SELECT * FROM LOCALIZACOES ORDER BY DATA_HORA DESC LIMIT 1 ", null);

            if(cursor.moveToNext())
            {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                locationMyModel.setData_hora(dateFormat.parse(cursor.getString(cursor.getColumnIndex("DATA_HORA"))));
                locationMyModel.setLongitude(cursor.getString(cursor.getColumnIndex("LONGITUDE")));
                locationMyModel.setLatitude(cursor.getString(cursor.getColumnIndex("LATITUDE")));
                locationMyModel.setProviderName(cursor.getString(cursor.getColumnIndex("PROVIDER_NAME")));
            }

            return locationMyModel;
        }
        catch (Exception e )
        {
            return null;
        }
    }


}
