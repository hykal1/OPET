package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;

import java.util.ArrayList;

public class sales_report_grooming extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rv_report;
    Report_Adapter reportAdapter;
    Spinner month;
    com.example.projectuas.DataBase.dbTransaksi dbTransaksi;
    ArrayList<Report_Data> report_data;
    ImageButton btn_arrowBack;

    public static String[] month_list = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report_grooming);

        Spinner month = (Spinner) findViewById(R.id.month);

        ArrayAdapter<String> month_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                month_list
        );
        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Terapkan adapter ke spinner
        month.setAdapter(month_adapter);
        month.setSelection(0);

        btn_arrowBack = findViewById(R.id.arrowBackButton_report_grooming);
        btn_arrowBack.setOnClickListener(this);

        dbTransaksi = new dbTransaksi(this);
        rv_report = findViewById(R.id.rv_data_report_grooming);
        report_data = dbTransaksi.get_report("groom", 0);
        reportAdapter = new Report_Adapter(report_data);
        rv_report.setHasFixedSize(true);
        rv_report.setLayoutManager(new LinearLayoutManager(this));
        rv_report.setAdapter(reportAdapter);
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Panggil metode atau lakukan sesuatu saat item dipilih
                report_data = dbTransaksi.get_report("groom", position+1);
                reportAdapter = new Report_Adapter(report_data);
                rv_report.setHasFixedSize(true);
                rv_report.setAdapter(reportAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Dapat diabaikan jika tidak ada yang dipilih
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_report_grooming) {
            Intent back = new Intent(sales_report_grooming.this, SalesReport.class);
            startActivity(back);
        }
    }
}