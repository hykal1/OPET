package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.feature.Veterinary.Veterinary;
import com.example.projectuas.feature.Veterinary.VeterinaryActivity;
import com.example.projectuas.login.login;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static String EXTRA_USERNAME = "USERNAME";
    TextView tv_username;
    ImageButton img_veterinary, img_grooming, img_food, img_accessories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra(EXTRA_USERNAME);

        tv_username = findViewById(R.id.username);
        tv_username.setText("Hello, "+username);
        img_veterinary = findViewById(R.id.button_veterinary_menu);
        img_grooming = findViewById(R.id.button_grooming_menu);
        img_food = findViewById(R.id.button_food_menu);
        img_accessories = findViewById(R.id.button_accessories_menu);

        img_veterinary.setOnClickListener(this);
        img_grooming.setOnClickListener(this);
        img_accessories.setOnClickListener(this);
        img_food.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_veterinary_menu) {
            Intent veterinary = new Intent(MainActivity.this, VeterinaryActivity.class);
            String username = getIntent().getStringExtra(EXTRA_USERNAME);
            veterinary.putExtra(VeterinaryActivity.EXTRA_NAME, username);
            startActivity(veterinary);
        } else if (v.getId()==R.id.button_grooming_menu) {
            Intent grooming = new Intent(MainActivity.this, GroomingActivity.class);
            String username = getIntent().getStringExtra(EXTRA_USERNAME);
            grooming.putExtra(GroomingActivity.EXTRA_NAME, username);
            startActivity(grooming);
        }
    }
}