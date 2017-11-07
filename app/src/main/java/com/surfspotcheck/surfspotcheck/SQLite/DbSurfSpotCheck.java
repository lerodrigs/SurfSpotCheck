package com.surfspotcheck.surfspotcheck.SQLite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbSurfSpotCheck
{

    /*@Override
    public void onCreate(SQLiteDatabase db)
    {
        StringBuilder createTables = new StringBuilder();

        createTables.append("CREATE TABLE LOCALIZACOES" +
                "( " +
                "ID_LOCALIZACAO NUMERIC(15) PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "LATITUDE NUMERIC(15) NOT NULL, " +
                "LONGITUDE NUMERIC(15) NOT NULL, " +
                "NOME VARCHAR(100) NULL" +
                "); ");

        createTables.append("CREATE TABLE CLIMATEMPOS" +
                "( " +
                "ID_CLIMATEMPO NUMERIC(15) PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "DATA DATETIME NOT NULL, " +
                "TEMP_MIN INTEGER NULL, " +
                "TEMP_MAX INTEGER NULL," +
                "DIRECAO_VENTO VARCHAR(60) NULL, " +
                "VELOCIDADE_VENTO VARCHAR(60) NULL, " +
                "DESCRICAO VARCHAR(100) NULL, " +
                "CIDADE VARCHAR(80) NULL, " +
                "CONDITION VARCHAR(60) NULL, " +
                "TEMP INTEGER NULL," +
                "DIA_SEMANA VARCHAR(60) NULL " +
                "); ");

        createTables.append("CREATE TABLE MARES(" +
                "ID_MARE NUMERIC(15) PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "DATA DATETIME NOT NULL, " +
                "ALTURA DECIMAL NOT NULL" +
                "); ");

        db.execSQL(createTables.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }*/

}
