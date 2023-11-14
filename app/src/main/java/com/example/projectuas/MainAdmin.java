package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.Session.Session;

public class MainAdmin extends AppCompatActivity implements View.OnClickListener{

    TextView username;
    ImageButton report, order;

    public static String EXTRA_USERNAME = "USERNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        Session session = new Session(this);
        String name = session.getUsername();

        username = findViewById(R.id.username);
        username.setText("Hello, "+name);
        report = findViewById(R.id.sales_report_menu);
        order = findViewById(R.id.incoming_order_menu);
        report.setOnClickListener(this);
        order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sales_report_menu){
            Intent report = new Intent(MainAdmin.this, sales_report.class);
            startActivity(report);
        }
    }
}