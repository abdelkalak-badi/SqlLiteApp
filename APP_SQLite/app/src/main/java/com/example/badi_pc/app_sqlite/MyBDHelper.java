package com.example.badi_pc.app_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyBDHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    //Version DB
    public static final String DATABASE_NAME="demo_DB.db";//Nom BD
    public static final String TABLE_Produits="Produits";//Nom de la table STOCK
    // Nom de colonnes Table STOCK
    public static final String KEY_ID="ID";
    public static final String KEY_Produits="Produit";
    public static final String KEY_QProduits="QProduits";
    public MyBDHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STOCK_TABLE =
                "CREATE TABLE " + TABLE_Produits + "("
                        + KEY_ID + " INTEGER PRIMARY KEY   AUTOINCREMENT,"
                        + KEY_Produits + " TEXT,"
                        + KEY_QProduits + " INTEGER" + ")";
        db.execSQL(CREATE_STOCK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Produits);
        // Create tables une autre fois
        onCreate(db);
    }
}
