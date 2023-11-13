package com.example.projectuas.feature.Grooming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectuas.R;

import java.util.ArrayList;

public class GroomingActivity extends AppCompatActivity {

    private RecyclerView rvGrooming;
    private ArrayList<Grooming> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming);

        rvGrooming = findViewById(R.id.rv_grooming);
        rvGrooming.setHasFixedSize(true);

        list.addAll(GroomingData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvGrooming.setLayoutManager(new LinearLayoutManager(this));
        GroomingAdapter cardViewHeroAdapter = new GroomingAdapter(list);
        rvGrooming.setAdapter(cardViewHeroAdapter);
    }
}