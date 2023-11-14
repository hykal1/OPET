package com.example.projectuas.feature.Grooming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.R;

public class GroomingBookingActivity extends AppCompatActivity implements View.OnClickListener{
    public static String EXTRA_GROOMING = "GROOMING";
    TextView name, desc, price, detail, count;
    ImageButton back, minus, plus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming_booking);
        back = findViewById(R.id.arrowBackButton_gro);

        name = findViewById(R.id.tv_book_groom);
        plus = findViewById(R.id.btn_groom_plus);
        minus = findViewById(R.id.btn_groom_min);
        desc = findViewById(R.id.tv_book_desc_groom);
        price = findViewById(R.id.tv_book_price);
        detail = findViewById(R.id.tv_book_detail);
        count = findViewById(R.id.tv_count_order);

        Grooming clicked = getIntent().getParcelableExtra(EXTRA_GROOMING);
        name.setText(clicked.getName_groom());
        desc.setText(clicked.getDesc_groom());
        price.append(String.valueOf(clicked.getPrice_groom()));
        detail.setText(clicked.getDetail_groom());
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Grooming clicked = getIntent().getParcelableExtra(EXTRA_GROOMING);
        if(v.getId()==R.id.arrowBackButton_gro){
            Intent back = new Intent(GroomingBookingActivity.this, GroomingActivity.class);
            startActivity(back);
        } else if (v.getId()==R.id.btn_groom_plus) {
            int value = Integer.valueOf(count.getText().toString());
            if(value<10){
                value+=1;
                count.setText(String.valueOf(value));
                price.setText("Rp. " + clicked.getPrice_groom()*value);
            }
        } else if (v.getId() == R.id.btn_groom_min) {
            int value = Integer.valueOf(count.getText().toString());
            if(value>1){
                value-=1;
                count.setText(String.valueOf(value));
                price.setText("Rp. " + clicked.getPrice_groom()*value);
            }
        }
    }
}