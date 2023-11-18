package com.example.projectuas.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;

import java.util.ArrayList;

public class IncomingOrderVeterinary extends AppCompatActivity implements View.OnClickListener {

    dbTransaksi dbTransaksi;
    ImageButton btn_arrowBack;
    RecyclerView rv_vet;
    OrderAdapter adapter;
    ArrayList<OrderData> orderDatalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incoming_order_veterinary);
        rv_vet = findViewById(R.id.rv_data_order_veterinary);
        dbTransaksi = new dbTransaksi(this);
        orderDatalist = dbTransaksi.getOrderDataVet();
        adapter = new OrderAdapter(orderDatalist);
        rv_vet.setHasFixedSize(true);
        rv_vet.setLayoutManager(new LinearLayoutManager(this));
        rv_vet.setAdapter(adapter);

        adapter.setOnItemClickCallBack(new OrderAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(OrderData data) {
                dbTransaksi.completeVet(data.getId());
                orderDatalist = dbTransaksi.getOrderDataVet();
                adapter.updateData(orderDatalist);
                adapter.notifyDataSetChanged();
            }
        });


        btn_arrowBack = findViewById(R.id.arrowBackButton_order_veterinary);
        btn_arrowBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_order_veterinary) {
            Intent back = new Intent(IncomingOrderVeterinary.this, IncomingOrder.class);
            startActivity(back);
        }
    }
}