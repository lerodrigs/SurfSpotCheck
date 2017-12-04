package com.surfspotcheck.surfspotcheck.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.io.File;


public class DbSurfSpotCheck extends SQLiteOpenHelper
{
    private static final String db_name = "db_ssc";
    private static final int version = 1; //version db

    public DbSurfSpotCheck(Context context)
    {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String path = db.getPath();
        File file = new File(path);

        if(!file.exists())
        {
            StringBuilder createTables = new StringBuilder();

            createTables.append("CREATE TABLE LOCALIZACOES" +
                    "( " +
                    "ID NUMERIC(15) PRIMARY KEY NOT NULL, " +
                    "LATITUDE VARCHAR(60) NULL, " +
                    "LONGITUDE VARCHAR(60) NULL, " +
                    "PROVIDER_NAME VARCHAR(100) NULL" +
                    "); ");

            db.execSQL(createTables.toString());
            db.setVersion(version);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //update database

        db.setVersion(newVersion);
    }
}
