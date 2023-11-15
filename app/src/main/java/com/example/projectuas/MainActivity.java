package com.example.projectuas;

import static android.text.TextUtils.replace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.Session.Session;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.feature.Veterinary.Veterinary;
import com.example.projectuas.feature.Veterinary.VeterinaryActivity;
import com.example.projectuas.feature.food.FoodActivity;
import com.example.projectuas.login.login;
import com.example.projectuas.navbar.HistoryFragment;
import com.example.projectuas.navbar.HomeFragment;
import com.example.projectuas.navbar.ProfileFragment;
import com.example.projectuas.profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_username;
    ImageButton btn_veterinary, btn_grooming, btn_food, btn_accessories;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Session user = new Session(this);
        String username = user.getUsername();

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

        bottomNavigationView = findViewById(R.id.bottom_navView);
        frameLayout = findViewById(R.id.frameLayout_Nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if (itemId == R.id.navHome){
                    loadFragment(new HomeFragment(), false);
                } else if (itemId == R.id.navHistory){
                    loadFragment(new HistoryFragment(), false);
                } else if (itemId == R.id.navProfile){
                    loadFragment(new ProfileFragment(), false);
                }
                return true;
            }
        });

        loadFragment(new HomeFragment(), true);
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

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout_Nav, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout_Nav, fragment);
        }

        fragmentTransaction.replace(R.id.frameLayout_Nav, fragment);
        fragmentTransaction.commit();
    }
}