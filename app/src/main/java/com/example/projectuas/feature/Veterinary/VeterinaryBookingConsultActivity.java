package com.example.projectuas.feature.Veterinary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectuas.R;

public class VeterinaryBookingConsultActivity extends AppCompatActivity {


    ImageView photo;
    TextView tv_consult_with, tv_consult_specialist, tv_detail, tv_price;
    public static String EXTRA_VETERINARY = "VETERINARY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary_booking_consult);
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
    }
}