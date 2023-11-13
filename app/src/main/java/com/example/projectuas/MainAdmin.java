package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainAdmin extends AppCompatActivity {

    TextView username;
    public static String EXTRA_USERNAME = "USERNAM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        String name = getIntent().getStringExtra(EXTRA_USERNAME);
        username = findViewById(R.id.username);
        username.setText("Hello, "+name);
    }
}