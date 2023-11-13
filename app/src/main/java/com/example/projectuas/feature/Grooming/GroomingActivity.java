package com.example.projectuas.feature.Grooming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.projectuas.MainActivity;
import com.example.projectuas.R;
import com.example.projectuas.feature.Veterinary.VeterinaryActivity;

import java.util.ArrayList;

public class GroomingActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvGrooming;
    private ArrayList<Grooming> list = new ArrayList<>();
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming);

        btnBack = findViewById(R.id.arrowBackButton_gro);
        btnBack.setOnClickListener(this);

        rvGrooming = findViewById(R.id.rv_grooming);
        rvGrooming.setHasFixedSize(true);

        list.addAll(GroomingData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvGrooming.setLayoutManager(new LinearLayoutManager(this));
        GroomingAdapter GroomingAdapter = new GroomingAdapter(list);
        rvGrooming.setAdapter(GroomingAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_gro) {
            Intent back = new Intent(GroomingActivity.this, MainActivity.class);
            startActivity(back);
        }
    }
}