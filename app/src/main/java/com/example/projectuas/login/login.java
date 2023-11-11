package com.example.projectuas.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.projectuas.R;

public class login extends AppCompatActivity {

    TextView slogan;
    ImageButton getStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        slogan = findViewById(R.id.slogan_splashScreen);
        String text = "Make you bonding relationship\n between Pets and Human";
        SpannableString spannableString = new SpannableString(text);

        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orange)), 39, 53, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        slogan.setText(spannableString);

        getStart = findViewById(R.id.get_started);
        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, login2.class);
                startActivity(intent);
            }
        });


    }
}