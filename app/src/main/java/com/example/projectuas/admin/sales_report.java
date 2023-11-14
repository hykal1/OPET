package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projectuas.R;

import java.util.ArrayList;
import java.util.Calendar;

public class sales_report extends AppCompatActivity implements View.OnClickListener {

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report);
        back = findViewById(R.id.arrowBackButton_report);
        back.setOnClickListener(this);

        Spinner month = (Spinner) findViewById(R.id.month);
        Spinner year = (Spinner) findViewById(R.id.year);

        ArrayAdapter<CharSequence> month_adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Month_dropdown,
                android.R.layout.simple_spinner_item
        );
        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Terapkan adapter ke spinner
        month.setAdapter(month_adapter);


        ArrayAdapter<CharSequence> year_adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Year_dropdown,
                android.R.layout.simple_spinner_item
        );
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Terapkan adapter ke spinner
        year.setAdapter(year_adapter);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.arrowBackButton_report){
            Intent main_admin = new Intent(sales_report.this, MainAdmin.class);
            startActivity(main_admin);
        }
    }
}