package com.example.projectuas.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

public class ProfileActivity extends AppCompatActivity {
    Session user = new Session(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}