package com.example.projectuas.feature.Veterinary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.MainActivity;
import com.example.projectuas.R;
import com.example.projectuas.feature.Grooming.Grooming;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.feature.Grooming.GroomingAdapter;
import com.example.projectuas.feature.Grooming.GroomingData;

import java.util.ArrayList;

public class VeterinaryActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvVeterinary;
    private ArrayList<Veterinary> list = new ArrayList<>();
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary);

        btnBack = findViewById(R.id.arrowBackButton_vet);
        btnBack.setOnClickListener(this);

        rvVeterinary = findViewById(R.id.rv_veterinary);
        rvVeterinary.setHasFixedSize(true);

        list.addAll(VeterinaryData.getListData());
        showRecyclerCardView();

    }

    private void showRecyclerCardView() {
        rvVeterinary.setLayoutManager(new LinearLayoutManager(this));
        VeterinaryAdapter VeterinaryAdapter = new VeterinaryAdapter(list);
        rvVeterinary.setAdapter(VeterinaryAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_vet) {
            Intent back = new Intent(VeterinaryActivity.this, MainActivity.class);
            startActivity(back);
        }
    }
}