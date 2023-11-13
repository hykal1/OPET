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
    public static final String TABLE_LAYANAN = "Layanan";
    public static final String TABLE_TRANSAKSI = "Transaksi";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_LAYANAN = "CREATE TABLE LAYANAN(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "jenis_layanan TEXT);";

    public dbTransaksi(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LAYANAN, null);
        buatLayanan();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @SuppressLint("Range")
    public void buatLayanan(){
        String selectQuery = "SELECT * FROM "+ TABLE_LAYANAN;
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<Layanan> listLayanan = new ArrayList<>();
        if(c.moveToFirst()){
            do {
                Layanan layanan = new Layanan();
                layanan.setId(c.getInt(c.getColumnIndex("Id")));
                layanan.setJenis_layanan(c.getString(c.getColumnIndex("jenis_layanan")));
                listLayanan.add(layanan);
            }while(c.moveToNext());
        }

        String[] list_layanan = GroomingData.GroomNames;

        if(listLayanan.size() == list_layanan.length){
            return;
        }else {
            for(int i=0; i<list_layanan.length; i++){
                ContentValues values = new ContentValues();
                values.put("jenis_layanan", list_layanan[i]);
                db.insert(TABLE_LAYANAN, null, values);
            }

        }

    }
}
