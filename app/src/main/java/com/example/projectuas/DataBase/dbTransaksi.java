package com.example.projectuas.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projectuas.admin.OrderData;
import com.example.projectuas.admin.Report_Data;
import com.example.projectuas.feature.Grooming.GroomingData;
import com.example.projectuas.object.Layanan;
import com.example.projectuas.object.ListLayanan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class dbTransaksi extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_Transaksi";
    public static final String TABLE_TRANSAKSI = "Transaksi_Veterinary";
    public static final String TABLE_TRANSAKSI2 = "Transaksi_Grooming";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_LAYANAN = "CREATE TABLE "+ TABLE_TRANSAKSI + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " + "Id_vet INTEGER, Id_user INTEGER, Jenis_layanan TEXT, biaya INTEGER, bulan INTEGER, tahun INTEGER, status TEXT);";
    public static final String CREATE_LAYANAN2 = "CREATE TABLE "+ TABLE_TRANSAKSI2 + "(Id INTEGER PRIMARY KEY AUTOINCREMENT, " + "Id_groom INTEGER, Id_user INTEGER, Jenis_layanan TEXT, biaya INTEGER, bulan INTEGER, tahun INTEGER, status TEXT);";

    public dbTransaksi(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LAYANAN);
        db.execSQL(CREATE_LAYANAN2);

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
        int tahun = calendar.get(Calendar.YEAR);
        ContentValues values = new ContentValues();
        values.put("Id_vet", id_vet);
        values.put("Id_user", id_user);
        values.put("Jenis_layanan", jenis_layanan);
        values.put("biaya", biaya);
        values.put("bulan", bulan);
        values.put("tahun", tahun);
        values.put("status", "incomplete");
        db.insert(TABLE_TRANSAKSI, null, values);
    }

    public void addGroom(int id_groom, int id_user, String jenis_layanan, int biaya){
        SQLiteDatabase db = this.getWritableDatabase();
        Calendar calendar = Calendar.getInstance();
        int bulan = calendar.get(Calendar.MONTH)+1;
        int tahun = calendar.get(Calendar.YEAR);
        ContentValues values = new ContentValues();
        values.put("Id_groom", id_groom);
        values.put("Id_user", id_user);
        values.put("Jenis_layanan", jenis_layanan);
        values.put("biaya", biaya);
        values.put("bulan", bulan);
        values.put("tahun", tahun);
        values.put("status", "incomplete");
        db.insert(TABLE_TRANSAKSI2, null, values);
    }

    public void completeGroom(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("status", "complete");
        db.update("Transaksi_grooming", values,"Id" + " = ?", new String[]{String.valueOf(id)});
    }

    public void completeVet(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("status", "complete");
        db.update("Transaksi_veterinary", values,"Id" + " = ?", new String[]{String.valueOf(id)});
    }

    @SuppressLint("Range")
    public ArrayList<Report_Data> get_report(String service_type, int month){
        ArrayList<Report_Data> result = new ArrayList<>();
        if(service_type.equals("vet")){
            String filterQuery = "SELECT Id_vet, Jenis_layanan, sum(biaya) as sum_prices from Transaksi_veterinary where bulan='" + month + "' group by jenis_layanan order by Id_vet;";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.rawQuery(filterQuery,null);
            if(c.moveToFirst()){
                do{
                    Report_Data row_data = new Report_Data();
                    row_data.setId(c.getInt(c.getColumnIndex("Id_vet")));
                    row_data.setServices(c.getString(c.getColumnIndex("Jenis_layanan")));
                    row_data.setSum(c.getInt(c.getColumnIndex("sum_prices")));
                    result.add(row_data);
                }while(c.moveToNext());
                return result;
            }
        }else if(service_type.equals("groom")){
            String filterQuery = "SELECT Id_groom, Jenis_layanan, sum(biaya) as sum_prices from Transaksi_grooming where bulan='" + month + "'group by jenis_layanan order by Id_groom;";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor c = db.rawQuery(filterQuery,null);
            if(c.moveToFirst()){
                do{
                    Report_Data row_data = new Report_Data();
                    row_data.setId(c.getInt(c.getColumnIndex("Id_groom")));
                    row_data.setServices(c.getString(c.getColumnIndex("Jenis_layanan")));
                    row_data.setSum(c.getInt(c.getColumnIndex("sum_prices")));
                    result.add(row_data);
                }while(c.moveToNext());
                return result;
            }
        }
        return result;
    }



    @SuppressLint("Range")
    public ArrayList<OrderData> getOrderDataGroom(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<OrderData> orderDataList = new ArrayList<>();
        String orderData = "SELECT Id, Jenis_layanan, biaya as sum_prices from Transaksi_grooming WHERE status = 'incomplete'";
        Cursor c = db.rawQuery(orderData, null);
        if(c.moveToFirst()){
            do{
                OrderData temp = new OrderData();
                temp.setId(c.getInt(c.getColumnIndex("Id")));
                temp.setServices(c.getString(c.getColumnIndex("Jenis_layanan")));
                temp.setPrices(c.getInt(c.getColumnIndex("sum_prices")));
                orderDataList.add(temp);
            }while(c.moveToNext());
            return orderDataList;
        }
        return orderDataList;
    }


    @SuppressLint("Range")
    public ArrayList<OrderData> getOrderDataVet(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<OrderData> orderDataList = new ArrayList<>();
        String orderData = "SELECT Id, Jenis_layanan, biaya as sum_prices from Transaksi_veterinary WHERE status = 'incomplete'";
        Cursor c = db.rawQuery(orderData, null);
        if(c.moveToFirst()){
            do{
                OrderData temp = new OrderData();
                temp.setId(c.getInt(c.getColumnIndex("Id")));
                temp.setServices(c.getString(c.getColumnIndex("Jenis_layanan")));
                temp.setPrices(c.getInt(c.getColumnIndex("sum_prices")));
                orderDataList.add(temp);
            }while(c.moveToNext());
            return orderDataList;
        }
        return orderDataList;
    }





}
