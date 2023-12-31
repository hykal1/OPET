package com.example.projectuas.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.projectuas.MainActivity;
import com.example.projectuas.R;
import com.example.projectuas.login.SignIn;


public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent untuk pindah ke activity selanjutnya
                Intent intent = new Intent(SplashScreen.this, SignIn.class);
                startActivity(intent);

                // Tutup activity splash screen
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}