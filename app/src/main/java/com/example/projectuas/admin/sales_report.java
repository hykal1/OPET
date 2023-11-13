package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projectuas.R;

import java.util.ArrayList;
import java.util.Calendar;

public class sales_report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report);

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
}