package com.example.projectuas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.Session.Session;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.feature.Veterinary.Veterinary;
import com.example.projectuas.feature.Veterinary.VeterinaryActivity;
import com.example.projectuas.feature.Veterinary.VeterinaryBookingConsultActivity;
import com.example.projectuas.feature.Veterinary.VeterinaryData;
import com.example.projectuas.feature.food.FoodActivity;
import com.example.projectuas.feature.accessories.AccessoriesActivity;
import com.example.projectuas.navbar.HistoryFragment;
import com.example.projectuas.navbar.HomeFragment;
import com.example.projectuas.navbar.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv_username;
    ImageButton btn_veterinary, btn_grooming, btn_food, btn_accessories, seeMore_vet, seeMore_groom, seeMore_food, seeMore_accessories ;
    private BottomNavigationView bottomNavigationView;
    Button order_now, consult_1st, consult_2nd;
    private FrameLayout frameLayout;
    ArrayList<Veterinary> veterinaries;

    dbTransaksi dbTransaksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Session user = new Session(this);
        String username = user.getUsername();
        dbTransaksi = new dbTransaksi(this);
        veterinaries = VeterinaryData.getListData();

        tv_username = findViewById(R.id.username);
        tv_username.setText("Hello, "+username);
        btn_veterinary = findViewById(R.id.button_veterinary_menu);
        btn_grooming = findViewById(R.id.button_grooming_menu);
        btn_food = findViewById(R.id.button_food_menu);
        btn_accessories = findViewById(R.id.button_accessories_menu);
        order_now = findViewById(R.id.order_now);
        seeMore_food = findViewById(R.id.see_more_food);
        seeMore_vet = findViewById(R.id.see_more_vet);
        seeMore_accessories = findViewById(R.id.see_more_accessories);
        seeMore_groom = findViewById(R.id.see_more_groom);
        consult_1st = findViewById(R.id.consult_1st);
        consult_2nd = findViewById(R.id.consult_2nd);

        btn_accessories.setOnClickListener(this);
        btn_veterinary.setOnClickListener(this);
        btn_food.setOnClickListener(this);
        btn_grooming.setOnClickListener(this);
        order_now.setOnClickListener(this);
        seeMore_groom.setOnClickListener(this);
        seeMore_accessories.setOnClickListener(this);
        seeMore_vet.setOnClickListener(this);
        seeMore_food.setOnClickListener(this);
        consult_1st.setOnClickListener(this);
        consult_2nd.setOnClickListener(this);

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
        if (v.getId() == R.id.button_veterinary_menu || v.getId() == R.id.see_more_vet) {
            Intent veterinary = new Intent(MainActivity.this, VeterinaryActivity.class);
            startActivity(veterinary);
        } else if (v.getId()==R.id.button_grooming_menu || v.getId()==R.id.order_now || v.getId() == R.id.see_more_groom) {
            Intent grooming = new Intent(MainActivity.this, GroomingActivity.class);
            startActivity(grooming);
        } else if(v.getId()==R.id.button_food_menu || v.getId() == R.id.see_more_food){
            Intent food = new Intent (MainActivity.this, FoodActivity.class);
            startActivity(food);
        } else if(v.getId()==R.id.button_accessories_menu || v.getId() == R.id.see_more_accessories){
            Intent accessories = new Intent (MainActivity.this, AccessoriesActivity.class);
            startActivity(accessories);
        } else if (v.getId()==R.id.consult_1st) {
            Veterinary first = veterinaries.get(3);
            Intent bookVet = new Intent(this, VeterinaryBookingConsultActivity.class);
            bookVet.putExtra(VeterinaryBookingConsultActivity.EXTRA_VETERINARY, first);
            startActivity(bookVet);
        }else if (v.getId()==R.id.consult_2nd) {
            Veterinary first = veterinaries.get(2);
            Intent bookVet = new Intent(this, VeterinaryBookingConsultActivity.class);
            bookVet.putExtra(VeterinaryBookingConsultActivity.EXTRA_VETERINARY, first);
            startActivity(bookVet);
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