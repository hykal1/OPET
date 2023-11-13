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
    public static String EXTRA_NAME = "NAME";
    TextView name, desc, price, detail;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming_booking);
        back = findViewById(R.id.arrowBackButton_gro);

        name = findViewById(R.id.tv_book_groom);
        desc = findViewById(R.id.tv_book_desc_groom);
        price = findViewById(R.id.tv_book_price);
        detail = findViewById(R.id.tv_book_detail);

        Grooming clicked = getIntent().getParcelableExtra(EXTRA_GROOMING);
        name.setText(clicked.getName_groom());
        desc.setText(clicked.getDesc_groom());
        price.setText(clicked.getPrice_groom());
        detail.setText(clicked.getDetail_groom());

        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.arrowBackButton_gro){
            Intent back = new Intent(GroomingBookingActivity.this, GroomingActivity.class);
            String username = getIntent().getStringExtra(EXTRA_NAME);
            back.putExtra(GroomingActivity.EXTRA_NAME, username);
            startActivity(back);
        }
    }
}