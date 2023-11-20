package com.example.projectuas.profile;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.projectuas.MainActivity;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;
import com.example.projectuas.DataBase.dbUser;
import com.example.projectuas.feature.Grooming.GroomingActivity;
import com.example.projectuas.navbar.ProfileFragment;

public class UpdateProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBack;
    private Button btnSubmit;
    public EditText username, password, new_password, confirm_password;
    Session user;
    dbUser dbUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        user = new Session(this);
        dbUser = new dbUser(this);

        btnBack = findViewById(R.id.arrowBackButton);
        btnBack.setOnClickListener(this);
        username = findViewById(R.id.edt_username);
        username.setText(user.getUsername());
        password = findViewById(R.id.edt_old_password);
        new_password = findViewById(R.id.edt_new_password);
        confirm_password = findViewById(R.id.edt_confirm_new_password);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton) {
            goToMainActivity();
        } else if (v.getId() == R.id.btn_submit) {
            String userName, oldPassword, newPassword, confirmPassword;
            userName = username.getText().toString();
            oldPassword = password.getText().toString();
            newPassword = new_password.getText().toString();
            confirmPassword = confirm_password.getText().toString();

            boolean isEmpty = false;

            if(userName.isEmpty()){
                username.setError("Username must filled!");
                isEmpty = true;

            }
            if(oldPassword.isEmpty()){
                password.setError("Password must filled!");
                isEmpty = true;
            }
            if(newPassword.isEmpty()){
                new_password.setError("Password must filled!");
                isEmpty = true;
            }
            if(confirmPassword.isEmpty()){
                confirm_password.setError("Password must filled!");
                isEmpty = true;
            }



            if(oldPassword.equals(newPassword) && isEmpty == false){
                new_password.setError("SAME WITH OLD PASSWORD");
                isEmpty = true;
            }
            if(!oldPassword.equals(user.getPassword()) && isEmpty==false){
                password.setError("Wrong Password!");
                isEmpty = true;
            }

            if(!newPassword.equals(confirmPassword)){
                new_password.setError("NOT MATCHED!");
                confirm_password.setError("NOT MATCHED!");
                isEmpty=true;
            }

            if(isEmpty == false){
                boolean update = dbUser.updateUser(user.getId(), userName, newPassword);
//                Kalau update success
                if(update == true){
                    user.editSession(userName, newPassword);
                    Toast.makeText(this, "Update Account Success!", Toast.LENGTH_SHORT).show();
                    goToMainActivity();
                }else{
                    username.setError("Username taken!");
                }

            }

        }
    }

    /*private void goToMyFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ProfileFragment profileFragment = new ProfileFragment();
        fragmentTransaction.replace(R.id.update_profile, profileFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/

    private void goToMainActivity() {
        Intent intent = new Intent(UpdateProfileActivity.this, MainActivity.class);
        startActivity(intent);
    }
}