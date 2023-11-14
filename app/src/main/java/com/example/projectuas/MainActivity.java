package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.Session.Session;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.feature.Veterinary.Veterinary;
import com.example.projectuas.feature.Veterinary.VeterinaryActivity;
import com.example.projectuas.feature.food.FoodActivity;
import com.example.projectuas.login.login;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_username;
    ImageButton btn_veterinary, btn_grooming, btn_food, btn_accessories;

    dbTransaksi dbTransaksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Session user = new Session(this);
        String username = user.getUsername();
        dbTransaksi = new dbTransaksi(this);

        tv_username = findViewById(R.id.username);
        tv_username.setText("Hello, "+username);
        btn_veterinary = findViewById(R.id.button_veterinary_menu);
        btn_grooming = findViewById(R.id.button_grooming_menu);
        btn_food = findViewById(R.id.button_food_menu);
        btn_accessories = findViewById(R.id.button_accessories_menu);

        btn_accessories.setOnClickListener(this);
        btn_veterinary.setOnClickListener(this);
        btn_food.setOnClickListener(this);
        btn_grooming.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_veterinary_menu) {
            Intent veterinary = new Intent(MainActivity.this, VeterinaryActivity.class);
            startActivity(veterinary);
        } else if (v.getId()==R.id.button_grooming_menu) {
            Intent grooming = new Intent(MainActivity.this, GroomingActivity.class);
            startActivity(grooming);
        } else if(v.getId()==R.id.button_food_menu){
            Intent food = new Intent (MainActivity.this, FoodActivity.class);
            startActivity(food);
        }
    }
}