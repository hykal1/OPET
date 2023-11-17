package com.example.projectuas.navbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

public class updetFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnBack;
    EditText username, password, new_password, confirm_password;
    Session user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_updet, container, false);
        user = new Session(getContext());
        btnBack = view.findViewById(R.id.arrowBackButton);
        username = getView().findViewById(R.id.edt_username);
        username.setText(user.getUsername());
        password = view.findViewById(R.id.edt_old_password);
        new_password = view.findViewById(R.id.edt_new_password);
        confirm_password = view.findViewById(R.id.edt_confirm_new_password);
        btnBack.setOnClickListener(this);

        return view;
    }

    private void goToMyFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        updetFragment updetFragment = new updetFragment();
        fragmentTransaction.replace(R.id.update_profile, updetFragment);

        // Untuk menambahkan fragment kedua ke back stack
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.arrowBackButton) {
            goToMyFragment();
        }
    }
}