package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.R;

public class IncomingOrderVeterinary extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_order_veterinary);

        btn_arrowBack = findViewById(R.id.arrowBackButton_order_veterinary);
        btn_arrowBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_order_veterinary) {
            Intent back = new Intent(IncomingOrderVeterinary.this, IncomingOrder.class);
            startActivity(back);
        }
    }
}