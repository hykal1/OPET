package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projectuas.login.login;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_USERNAME = "USERNAME";
    TextView tv_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        tv_username = findViewById(R.id.username);
        tv_username.setText("Hello, "+username);


    }
}