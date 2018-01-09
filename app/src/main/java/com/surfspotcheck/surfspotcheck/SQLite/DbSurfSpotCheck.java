package com.surfspotcheck.surfspotcheck.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.io.File;


public class DbSurfSpotCheck extends SQLiteOpenHelper
{
    private static final String db_name = "db_ssc.db3";
    private static final int version = 1; //version db

    public DbSurfSpotCheck(Context context)
    {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String messageError = null;

        try
        {
            StringBuilder createTables = new StringBuilder();

            createTables.append("CREATE TABLE IF NOT EXISTS LOCALIZACOES" +
                    "( " +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "DATA_HORA DATETIME NULL, " +
                        "LATITUDE VARCHAR(60) NULL, " +
                        "LONGITUDE VARCHAR(60) NULL, " +
                        "PROVIDER_NAME VARCHAR(100) NULL" +
                    "); ");

            db.execSQL(createTables.toString());
            db.setVersion(version);
        }
        catch(SQLiteException e )
        {
            messageError = e.getMessage();
        }
        catch (Exception e )
        {
            messageError = e.getMessage();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //update database
        db.setVersion(newVersion);
    }

    @Override
    public void onConfigure(SQLiteDatabase db)
    {

    }
}
