package com.example.projectuas.profile;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.projectuas.MainActivity;
import com.example.projectuas.R;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.navbar.ProfileFragment;

public class UpdateProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBack;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        btnBack = findViewById(R.id.arrowBackButton);
        btnBack.setOnClickListener(this);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton) {
            goToMainActivity();
        } else if (v.getId() == R.id.btn_submit) {
            goToMainActivity();
        }
    }

    /*private void goToMyFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ProfileFragment profileFragment = new ProfileFragment();
        fragmentTransaction.replace(R.id.update_profile, profileFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/

    private void goToMainActivity() {
        Intent intent = new Intent(UpdateProfileActivity.this, MainActivity.class);
        startActivity(intent);
    }
}