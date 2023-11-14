package com.example.projectuas.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectuas.MainActivity;
import com.example.projectuas.admin.MainAdmin;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    Button login, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Session user = new Session(this);
        if(user.isLoggedIn()){
            if(user.getUsername().equals("admin")){
                Intent admin = new Intent(SignIn.this, MainAdmin.class);
                startActivity(admin);
                finish();
            }else{
                Intent customer = new Intent(SignIn.this, MainActivity.class);
                startActivity(customer);
                finish();
            }
        }

        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(this);

        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);


        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        fragment_login login = new fragment_login();
        mFragmentTransaction.add(R.id.frame_login_signup, login, fragment_login.class.getSimpleName());

        mFragmentTransaction.commit();





    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login){
            login.setTextColor(getResources().getColor(R.color.black));
            signup.setTextColor(getResources().getColor(R.color.gray));
            FragmentManager mFragmentManager = getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            fragment_login login = new fragment_login();
            mFragmentTransaction.replace(R.id.frame_login_signup, login, fragment_login.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
        if(v.getId() == R.id.signup){
            signup.setTextColor(getResources().getColor(R.color.black));
            login.setTextColor(getResources().getColor(R.color.gray));
            FragmentManager mFragmentManager = getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            fragment_signup signUp = new fragment_signup();
            mFragmentTransaction.replace(R.id.frame_login_signup, signUp, fragment_signup.class.getSimpleName());
            mFragmentTransaction.addToBackStack(null);
            mFragmentTransaction.commit();
        }
    }
}