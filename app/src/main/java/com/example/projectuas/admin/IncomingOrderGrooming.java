package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;

import java.util.ArrayList;

public class IncomingOrderGrooming extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_arrowBack;
    RecyclerView rv_groom;
    OrderAdapter adapter;
    dbTransaksi dbTransaksi;
    ArrayList<OrderData> orderDatalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_order_grooming);
        dbTransaksi = new dbTransaksi(this);
        rv_groom = findViewById(R.id.rv_data_order_grooming);
        orderDatalist = new ArrayList<>();
        orderDatalist = dbTransaksi.getOrderDataGroom();
        adapter = new OrderAdapter(orderDatalist);
        Toast.makeText(this, ""+adapter.getItemCount(), Toast.LENGTH_SHORT).show();

        rv_groom.setHasFixedSize(true);
        rv_groom.setLayoutManager(new LinearLayoutManager(this));
        rv_groom.setAdapter(adapter);

        btn_arrowBack = findViewById(R.id.arrowBackButton_order_grooming);
        btn_arrowBack.setOnClickListener(this);
        adapter.setOnItemClickCallBack(new OrderAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(OrderData data) {
                dbTransaksi.completeGroom(data.getId());
                orderDatalist = dbTransaksi.getOrderDataGroom();
                adapter.updateData(orderDatalist);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_order_grooming) {
            Intent back = new Intent(IncomingOrderGrooming.this, IncomingOrder.class);
            startActivity(back);
        }
    }
}