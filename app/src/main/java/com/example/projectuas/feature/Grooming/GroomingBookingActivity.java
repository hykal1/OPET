package com.example.projectuas.feature.Grooming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;
import com.example.projectuas.feature.Veterinary.Veterinary;

public class GroomingBookingActivity extends AppCompatActivity implements View.OnClickListener{
    public static String EXTRA_GROOMING = "GROOMING";
    TextView name, desc, price, detail, count;
    ImageButton back, minus, plus;
    Button book;
    dbTransaksi dbTransaksi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grooming_booking);
        back = findViewById(R.id.arrowBackButton_gro);
        dbTransaksi = new dbTransaksi(this);

        name = findViewById(R.id.tv_book_groom);
        plus = findViewById(R.id.btn_groom_plus);
        minus = findViewById(R.id.btn_groom_min);
        desc = findViewById(R.id.tv_book_desc_groom);
        price = findViewById(R.id.tv_book_price);
        detail = findViewById(R.id.tv_book_detail);
        count = findViewById(R.id.tv_count_order);
        book = findViewById(R.id.btn_book_groom);

        Grooming clicked = getIntent().getParcelableExtra(EXTRA_GROOMING);
        name.setText(clicked.getName_groom());
        desc.setText(clicked.getDesc_groom());
        price.append(String.valueOf(clicked.getPrice_groom()));
        detail.setText(clicked.getDetail_groom());
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        back.setOnClickListener(this);
        book.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Grooming clicked = getIntent().getParcelableExtra(EXTRA_GROOMING);
        if(v.getId()==R.id.arrowBackButton_gro){
            Intent back = new Intent(GroomingBookingActivity.this, GroomingActivity.class);
            startActivity(back);
        } else if (v.getId()==R.id.btn_groom_plus) {
            int value = Integer.valueOf(count.getText().toString());
            if(value<10){
                value+=1;
                count.setText(String.valueOf(value));
                price.setText("Rp. " + clicked.getPrice_groom()*value);
            }
        } else if (v.getId() == R.id.btn_groom_min) {
            int value = Integer.valueOf(count.getText().toString());
            if(value>1){
                value-=1;
                count.setText(String.valueOf(value));
                price.setText("Rp. " + clicked.getPrice_groom()*value);
            }
        }else if (v.getId()==R.id.btn_book_groom) {
            tampilkanDialog();
        }
    }

    private void tampilkanDialog() {
        Session logged_in = new Session(this);
        Grooming clicked = getIntent().getParcelableExtra(EXTRA_GROOMING);
        // Membuat objek AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Mengatur judul dan pesan dialog
        builder.setTitle("Konfirmasi Book")
                .setMessage("Apakah kamu yakin akan melakukan book?");

        // Menambahkan tombol positif (biasanya OK atau Setuju)
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Aksi yang akan dilakukan saat tombol positif diklik
//                Input data ke database
                int value = Integer.valueOf(count.getText().toString());
                dbTransaksi.addGroom(clicked.getId_groom(), logged_in.getId(), clicked.getName_groom(), clicked.getPrice_groom()*value);
                dialogInterface.dismiss(); // Menutup dialog
                successDialog();
            }
        });

        // Menambahkan tombol negatif (biasanya Batal atau Batalkan)
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
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

    private void successDialog() {
        // Membuat objek Dialog
        final Dialog dialog = new Dialog(this);

        // Mengatur tata letak tampilan dialog menggunakan layout kustom
        dialog.setContentView(R.layout.dialog_book_success);

        // Menambahkan aksi untuk tombol di dalam dialog kustom
        Button buttonClose = dialog.findViewById(R.id.OKE);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aksi yang akan dilakukan saat tombol di dalam dialog diklik
                dialog.dismiss(); // Menutup dialog
            }
        });

        // Menampilkan dialog
        dialog.show();
    }
}