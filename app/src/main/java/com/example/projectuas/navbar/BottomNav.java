package com.example.projectuas.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.projectuas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNav extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

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

                loadFragment(new HomeFragment(), true);

                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.frameLayout_Nav, fragment);
        } else {
            fragmentTransaction.replace(R.id.frameLayout_Nav, fragment);
        }

        fragmentTransaction.commit();

    }
}