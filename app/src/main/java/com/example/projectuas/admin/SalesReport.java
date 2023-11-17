package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.R;

public class SalesReport extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_arrowBack, report_groming, report_veterinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report);

        btn_arrowBack = findViewById(R.id.arrowBackButton_sales);
        report_groming = findViewById(R.id.report_veterinary);
        report_veterinary = findViewById(R.id.report_grooming);

        btn_arrowBack.setOnClickListener(this);
        report_groming.setOnClickListener(this);
        report_veterinary.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.arrowBackButton_sales){
            Intent back = new Intent(SalesReport.this, MainAdmin.class);
            startActivity(back);
        } else if (v.getId()==R.id.report_veterinary) {
            Intent veterinary = new Intent(SalesReport.this, sales_report_veterinary.class);
            startActivity(veterinary);
        } else if (v.getId()==R.id.report_grooming) {
            Intent grooming = new Intent(SalesReport.this, sales_report_grooming.class);
            startActivity(grooming);
        }
    }
}