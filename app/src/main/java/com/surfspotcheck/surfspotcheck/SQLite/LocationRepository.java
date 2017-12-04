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
            db_ssc = dbSurfSpotCheck.getReadableDatabase();

            Cursor cursor = db_ssc.rawQuery("SELECT TOP +1+ ID " +
                    "                        FROM LOCALIZACOES", null);

            if(!cursor.moveToFirst() )
            {
                db_ssc.beginTransaction();

                String command = "INSERT INTO LOCALIZACOES " +
                        "(" +
                        "LATITUDE, LONGITUDE, PROVIDER_NAME" +
                        ")" +
                        "VALUES" +
                        "(" +
                        locationmMyModel.getLatitude() +
                        locationmMyModel.getLongitude() +
                        locationmMyModel.getProviderName() +
                        ");";

                db_ssc.execSQL(command);
                db_ssc.endTransaction();
            }
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
            LocationMyModel locationMyModel = null;
            return locationMyModel;
        }
        catch (Exception e )
        {
            return null;
        }
    }


}
