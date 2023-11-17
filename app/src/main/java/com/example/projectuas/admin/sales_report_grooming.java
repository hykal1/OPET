package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.R;

public class sales_report_grooming extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report_grooming);

        btn_arrowBack = findViewById(R.id.arrowBackButton_report_grooming);
        btn_arrowBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_report_grooming) {
            Intent back = new Intent(sales_report_grooming.this, SalesReport.class);
            startActivity(back);
        }
    }
}