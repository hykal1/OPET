package com.example.projectuas.admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.Session.Session;
import com.example.projectuas.R;
import com.example.projectuas.login.SignIn;

public class MainAdmin extends AppCompatActivity implements View.OnClickListener{

    TextView username;
    ImageButton report, order;
    Button logout;

    public static String EXTRA_USERNAME = "USERNAME";

    Session user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        user = new Session(this);
        String name = user.getUsername();

        logout = findViewById(R.id.logout);
        username = findViewById(R.id.username);
        username.setText("Hello, "+name);
        report = findViewById(R.id.sales_report_menu);
        order = findViewById(R.id.incoming_order_menu);
        report.setOnClickListener(this);
        order.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.sales_report_menu){
            Intent report = new Intent(MainAdmin.this, sales_report.class);
            startActivity(report);
        } else if (v.getId()==R.id.logout) {
            tampilkanDialog();
        }
    }


    private void tampilkanDialog() {
        // Membuat objek AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Mengatur judul dan pesan dialog
        builder.setTitle("Confirm Log Out")
                .setMessage("Are you sure want to Log Out?");

        // Menambahkan tombol positif (biasanya OK atau Setuju)
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Aksi yang akan dilakukan saat tombol positif diklik
//                Input data ke database

                dialogInterface.dismiss(); // Menutup dialog
                user.logout();
                Intent logout = new Intent(MainAdmin.this, SignIn.class);
                startActivity(logout);
                finish();
            }
        });

        // Menambahkan tombol negatif (biasanya Batal atau Batalkan)
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Aksi yang akan dilakukan saat tombol negatif diklik
                dialogInterface.dismiss(); // Menutup dialog
            }
        });

        // Membuat dan menampilkan AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}