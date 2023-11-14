package com.example.projectuas.Session;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    private static final String PREFERENCES_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private SharedPreferences sharedPreferences;

    public Session(Context context){
        sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void saveSession(int id,String username, String email, String password){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putInt(KEY_ID, id);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }

    public String getUsername(){
        return sharedPreferences.getString(KEY_USERNAME,"");
    }

    public int getId(){
        return sharedPreferences.getInt(KEY_ID,0);
    }

    public boolean isLoggedIn() {
        return sharedPreferences.contains(KEY_USERNAME);
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
