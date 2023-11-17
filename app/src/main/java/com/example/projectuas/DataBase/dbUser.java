package com.example.projectuas.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.projectuas.login.SignIn;
import com.example.projectuas.object.User;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class dbUser extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_opet";
    public static final String TABLE_NAME = "User";
    public static final int DATABASE_VERSION = 1;
    public static final String KEY_NAME = "user_name";
    public static final String KEY_ID = "id";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";

    private static final String CREATE_TABLE_USER = "CREATE TABLE "
        + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT,"+
            KEY_PASSWORD + " TEXT);";


    public dbUser(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        onCreate(db);
    }

    public long addUserDetail(String user, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, password);
        long insert = db.insert(TABLE_NAME, null, values);
        return insert;
    }

    @SuppressLint("Range")
    public boolean updateUser(int id, String username, String newPassword){
        String checkUsername = "SELECT * FROM User where user_name='" + username +"';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(checkUsername, null);
        if(c.moveToFirst()){
            int found_id;
            do{
                found_id = c.getInt(c.getColumnIndex(KEY_ID));
                break;
            }while(c.moveToNext());
            if(found_id == id){
                ContentValues values = new ContentValues();
                values.put(KEY_NAME, username);
                values.put(KEY_PASSWORD, newPassword);
                db.update(TABLE_NAME, values, KEY_ID +" = ?", new String[]{String.valueOf(id)} );
                return true;
            }else{
                return false;
            }
        }else{
            ContentValues values = new ContentValues();
            values.put(KEY_NAME, username);
            values.put(KEY_PASSWORD, newPassword);
            db.update(TABLE_NAME, values, KEY_ID +" = ?", new String[]{String.valueOf(id)} );
            return true;
        }


    }

    @SuppressLint("Range")
    public ArrayList<User> getAllUsers(){
        ArrayList<User> userArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()){
            do{
                User user = new User();
                user.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                user.setUsername(c.getString(c.getColumnIndex(KEY_NAME)));
                user.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                user.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
                userArrayList.add(user);
            }while(c.moveToNext());
        }
        return  userArrayList;
    }

    @SuppressLint("Range")
    public int checkAccount(String username, String password, String email){
        String selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()){
            do{
                String temp_username = c.getString(c.getColumnIndex(KEY_NAME));
                String temp_email = c.getString(c.getColumnIndex(KEY_EMAIL));
                String temp_password = c.getString(c.getColumnIndex(KEY_PASSWORD));
                if(username.equals(temp_username)){
                    if(password.equals(temp_password)){
//                        Return 1 jika akun ditemukan dan sesuai (BERHASIL LOGIN)
                        return 1;
                    }else{
//                        Return 2 jika akun ditemukan tetapi password salah
                        return 2;
                    }
//                    Email sudah digunakan
                } else if (email.equals(temp_email)) {
                    return 3;
                }
            }while(c.moveToNext());
        }
//        Return 0 jika akun tidak ditemukan
     return 0;

    }

    @SuppressLint("Range")
    public int loginAuthentication(String username, String password){
        String selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if(c.moveToFirst()){
            do{
                String temp_username = c.getString(c.getColumnIndex(KEY_NAME));
                String temp_password = c.getString(c.getColumnIndex(KEY_PASSWORD));
                if(username.equals(temp_username)){
                    if(password.equals(temp_password)){
//                        Return 1 jika akun ditemukan dan sesuai (BERHASIL LOGIN)
                        return 1;
                    }else{
//                        Return 2 jika akun ditemukan tetapi password salah
                        return 2;
                    }
//
                }
            }while(c.moveToNext());
        }
//        Return 0 jika akun tidak ditemukan
        return 0;
    }

    @SuppressLint("Range")
    public User getAccount(String username, String password){
        String selectQuery = "SELECT * FROM User where user_name='" +username + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        User logging_in = new User();
        if(c.moveToFirst()){
            logging_in.setId((c.getInt(c.getColumnIndex(KEY_ID))));
            logging_in.setUsername(c.getString(c.getColumnIndex(KEY_NAME)));
            logging_in.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
            logging_in.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
        }
        c.close();
        return logging_in;
    }


}
