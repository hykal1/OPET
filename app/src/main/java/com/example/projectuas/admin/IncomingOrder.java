package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.R;

public class IncomingOrder extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_arrowBack, order_groming, order_veterinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_order);

        btn_arrowBack = findViewById(R.id.arrowBackButton_order);
        order_groming = findViewById(R.id.incoming_order_veterinary);
        order_veterinary = findViewById(R.id.incoming_order_grooming);

        btn_arrowBack.setOnClickListener(this);
        order_groming.setOnClickListener(this);
        order_veterinary.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.arrowBackButton_order){
            Intent back = new Intent(IncomingOrder.this, MainAdmin.class);
            startActivity(back);
        } else if (v.getId()==R.id.incoming_order_veterinary) {
            Intent veterinary = new Intent(IncomingOrder.this, IncomingOrderVeterinary.class);
            startActivity(veterinary);
        } else if (v.getId()==R.id.incoming_order_grooming) {
            Intent grooming = new Intent(IncomingOrder.this, IncomingOrderGrooming.class);
            startActivity(grooming);
        }
    }
}