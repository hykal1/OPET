package com.example.projectuas.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projectuas.feature.Grooming.GroomingData;
import com.example.projectuas.object.Layanan;
import com.example.projectuas.object.ListLayanan;

import java.util.ArrayList;

public class dbTransaksi extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_opet";
    public static final String KEY_LAYANAN = "Layanan";
    public static final String TABLE_TRANSAKSI = "Transaksi_Groom";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_LAYANAN = "CREATE TABLE "+ TABLE_TRANSAKSI+ "(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Id_groom INTEGER, Id_user INTEGER, Jenis_layanan TEXT, biaya INTEGER);";

    public dbTransaksi(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LAYANAN, null);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_TRANSAKSI + "'");
        onCreate(db);
    }




}
