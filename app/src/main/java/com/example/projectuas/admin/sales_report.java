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
import android.widget.TextView;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;

import java.util.ArrayList;
import java.util.Calendar;

public class sales_report extends AppCompatActivity implements View.OnClickListener {

    ImageButton back;
    RecyclerView rv_report;
    Report_Adapter reportAdapter;
    Spinner month, year;
    dbTransaksi dbTransaksi;
    ArrayList<Report_Data> report_data;
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
        setContentView(R.layout.activity_sales_report);
        back = findViewById(R.id.arrowBackButton_report);
        back.setOnClickListener(this);


        Spinner month = (Spinner) findViewById(R.id.month);
        Spinner year = (Spinner) findViewById(R.id.year);

        ArrayAdapter<String> month_adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                month_list
        );
        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Terapkan adapter ke spinner
        month.setAdapter(month_adapter);
        month.setSelection(0);


        ArrayAdapter<CharSequence> year_adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Year_dropdown,
                android.R.layout.simple_spinner_item
        );
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Terapkan adapter ke spinner
        year.setAdapter(year_adapter);


        dbTransaksi = new dbTransaksi(this);
        rv_report = findViewById(R.id.rv_data_report);
        report_data = dbTransaksi.get_report("vet", 0);
        reportAdapter = new Report_Adapter(report_data);
        rv_report.setHasFixedSize(true);
        rv_report.setLayoutManager(new LinearLayoutManager(this));
        rv_report.setAdapter(reportAdapter);
        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Panggil metode atau lakukan sesuatu saat item dipilih
                report_data = dbTransaksi.get_report("vet", position+1);
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
        if(v.getId()==R.id.arrowBackButton_report){
            Intent main_admin = new Intent(sales_report.this, MainAdmin.class);
            startActivity(main_admin);
        }
    }

    public int getMonth(String bulan){
        String selected = month.getSelectedItem().toString();
        for(int i=0; i<month_list.length; i++){
            if(selected.equals(bulan)){
                return i+1;
            }
        }
        return -1;
    }
}