package com.example.projectuas.feature.Veterinary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

public class VeterinaryBookingConsultActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView photo;
    ImageButton back, plus, minus;
    Button book;
    TextView tv_consult_with, tv_consult_specialist, tv_detail, tv_price, count;
    dbTransaksi dbTransaksi;
    public static String EXTRA_VETERINARY = "VETERINARY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary_booking_consult);
        back = findViewById(R.id.arrowBackButton_vet);
        dbTransaksi = new dbTransaksi(this);

        photo = findViewById(R.id.img_photo_landscape);
        tv_consult_specialist = findViewById(R.id.tv_consult_specialist);
        tv_consult_with = findViewById(R.id.tv_consult_with);
        tv_detail = findViewById(R.id.tv_consult_detail);
        tv_price = findViewById(R.id.tv_consult_price);
        plus = findViewById(R.id.btn_plus);
        minus = findViewById(R.id.btn_min);
        count = findViewById(R.id.tv_count_order);
        book = findViewById(R.id.btn_book_consult);

        Veterinary clicked = getIntent().getParcelableExtra(EXTRA_VETERINARY);
        photo.setImageResource(clicked.getPhoto_land());
        tv_consult_specialist.setText(clicked.getDesc_vet());
        tv_consult_with.append(clicked.getName_vet());
        tv_price.setText(String.valueOf("Rp. "+clicked.getPrice_vet()));
        tv_detail.setText(clicked.getDetail_vet());

        back.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        book.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Veterinary clicked = getIntent().getParcelableExtra(EXTRA_VETERINARY);
        if (v.getId() == R.id.arrowBackButton_vet) {
            Intent back = new Intent(VeterinaryBookingConsultActivity.this, VeterinaryActivity.class);
            startActivity(back);
        } else if (v.getId()==R.id.btn_min) {
            int value = Integer.valueOf(count.getText().toString());
            if(value>1){
                value-=1;
                count.setText(String.valueOf(value));
                tv_price.setText("Rp. " + clicked.getPrice_vet()*value);
            }
        } else if (v.getId()==R.id.btn_plus) {
            int value = Integer.valueOf(count.getText().toString());
            if(value<10){
                value+=1;
                count.setText(String.valueOf(value));
                tv_price.setText("Rp. " + clicked.getPrice_vet()*value);
            }
        } else if (v.getId()==R.id.btn_book_consult) {
            tampilkanDialog();
        }
    }
    private void tampilkanDialog() {
        Session logged_in = new Session(this);
        Veterinary clicked = getIntent().getParcelableExtra(EXTRA_VETERINARY);
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
                dbTransaksi.addVeterinary(clicked.getId_vet(), logged_in.getId(), clicked.getName_vet(), clicked.getPrice_vet()*value);
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