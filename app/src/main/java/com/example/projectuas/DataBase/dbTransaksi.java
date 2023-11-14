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
import java.util.Calendar;

public class dbTransaksi extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_Transaksi";
    public static final String KEY_LAYANAN = "Layanan";
    public static final String TABLE_TRANSAKSI = "Transaksi_Veterinary";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_LAYANAN = "CREATE TABLE "+ TABLE_TRANSAKSI + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " + "Id_vet INTEGER, Id_user INTEGER, Jenis_layanan TEXT, biaya INTEGER, bulan INTEGER);";

    public dbTransaksi(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LAYANAN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_TRANSAKSI + "'");
        onCreate(db);
    }


    public void addVeterinary(int id_vet, int id_user, String jenis_layanan, int biaya){
        SQLiteDatabase db = this.getWritableDatabase();
        Calendar calendar = Calendar.getInstance();
        int bulan = calendar.get(Calendar.MONTH)+1;
        ContentValues values = new ContentValues();
        values.put("Id_vet", id_vet);
        values.put("Id_user", id_user);
        values.put("Jenis_layanan", jenis_layanan);
        values.put("biaya", biaya);
        values.put("bulan", bulan);
        db.insert(TABLE_TRANSAKSI, null, values);
    }




}
