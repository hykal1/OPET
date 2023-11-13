package com.example.projectuas.feature.Veterinary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectuas.R;

public class VeterinaryBookingConsultActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView photo;
    ImageButton back;
    TextView tv_consult_with, tv_consult_specialist, tv_detail, tv_price;
    public static String EXTRA_VETERINARY = "VETERINARY";
    public static String EXTRA_NAME = "NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary_booking_consult);
        back = findViewById(R.id.arrowBackButton_vet);

        photo = findViewById(R.id.img_photo_landscape);
        tv_consult_specialist = findViewById(R.id.tv_consult_specialist);
        tv_consult_with = findViewById(R.id.tv_consult_with);
        tv_detail = findViewById(R.id.tv_consult_detail);
        tv_price = findViewById(R.id.tv_consult_price);

        Veterinary clicked = getIntent().getParcelableExtra(EXTRA_VETERINARY);
        photo.setImageResource(clicked.getPhoto_land());
        tv_consult_specialist.setText(clicked.getDesc_vet());
        tv_consult_with.append(clicked.getName_vet());
        tv_price.setText(clicked.getPrice_vet());
        tv_detail.setText(clicked.getDetail_vet());

        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton_vet) {
            Intent back = new Intent(VeterinaryBookingConsultActivity.this, VeterinaryActivity.class);
            String username = getIntent().getStringExtra(EXTRA_NAME);
            back.putExtra(VeterinaryActivity.EXTRA_NAME, username);
            startActivity(back);
        }
    }
}