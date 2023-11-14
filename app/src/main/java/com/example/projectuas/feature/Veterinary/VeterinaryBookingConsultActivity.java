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
    ImageButton back, plus, minus;
    TextView tv_consult_with, tv_consult_specialist, tv_detail, tv_price, count;
    public static String EXTRA_VETERINARY = "VETERINARY";
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
        plus = findViewById(R.id.btn_plus);
        minus = findViewById(R.id.btn_min);
        count = findViewById(R.id.tv_count_order);

        Veterinary clicked = getIntent().getParcelableExtra(EXTRA_VETERINARY);
        photo.setImageResource(clicked.getPhoto_land());
        tv_consult_specialist.setText(clicked.getDesc_vet());
        tv_consult_with.append(clicked.getName_vet());
        tv_price.setText(String.valueOf("Rp. "+clicked.getPrice_vet()));
        tv_detail.setText(clicked.getDetail_vet());

        back.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
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
        }
    }
}