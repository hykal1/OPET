package com.example.projectuas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projectuas.Session.Session;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.feature.Veterinary.Veterinary;
import com.example.projectuas.feature.Veterinary.VeterinaryActivity;
import com.example.projectuas.feature.food.FoodActivity;
import com.example.projectuas.login.login;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_USERNAME = "USERNAME";
    TextView tv_username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Session user = new Session(this);
        String username = user.getUsername();

        tv_username = findViewById(R.id.username);
        tv_username.setText("Hello, "+username);


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