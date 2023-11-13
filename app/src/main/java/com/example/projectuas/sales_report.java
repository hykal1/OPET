package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class sales_report extends AppCompatActivity {
    TextView tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_report);
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH)+1;
        tanggal = findViewById(R.id.tanggal);
        tanggal.append(String.valueOf(currentMonth));

    }
}