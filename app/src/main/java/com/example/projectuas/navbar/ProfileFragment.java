package com.example.projectuas.navbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectuas.R;
import com.example.projectuas.Session.Session;
import com.example.projectuas.feature.Veterinary.Veterinary;
import com.example.projectuas.login.SignIn;
import com.example.projectuas.profile.UpdateProfileActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener{
    Session user;
    TextView username, email, password;
    Button btn_logout, btn_update;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        user = new Session(getContext());
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btn_logout = view.findViewById(R.id.btn_profile_logout);
        btn_update = view.findViewById(R.id.btn_profile_update);

        username = view.findViewById(R.id.tv_profile_username);
        username.setText(user.getUsername());
        email = view.findViewById(R.id.tv_profile_email);
        email.setText(user.getEmail());
        password = view.findViewById(R.id.tv_profile_pass);
        password.setText(user.getPassword());
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());


        btn_logout.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_profile_logout){
            tampilkanDialog();
        } else if (v.getId()==R.id.btn_profile_update) {
            goToUpdateActivity();
        }

    }

    private void goToUpdateActivity() {
        Intent intent = new Intent(getActivity(), UpdateProfileActivity.class);
        startActivity(intent);
    }

    /*private void goToMyFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        updetFragment myFragment = new updetFragment();
        fragmentTransaction.replace(R.id.fragmentupdeto, myFragment);
        fragmentTransaction.commit();
    }*/



    private void tampilkanDialog() {
        // Membuat objek AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                Intent logout = new Intent(getActivity(), SignIn.class);
                startActivity(logout);
                getActivity().finish();
            }
        });

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