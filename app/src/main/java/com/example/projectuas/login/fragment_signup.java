package com.example.projectuas.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectuas.DataBase.dbUser;
import com.example.projectuas.MainActivity;
import com.example.projectuas.MainAdmin;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_signup#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_signup extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_signup() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_signup.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_signup newInstance(String param1, String param2) {
        fragment_signup fragment = new fragment_signup();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    dbUser dbUser;
    private EditText userName, email, password, confirm_password;
    private Button signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        userName = view.findViewById(R.id.username);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        confirm_password = view.findViewById(R.id.password_confirm);
        signUp = view.findViewById(R.id.sign_up);
        dbUser = new dbUser(requireContext());

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name, user_email, user_password, user_conf_password;
                user_name = userName.getText().toString();
                user_email = email.getText().toString();
                user_password = password.getText().toString();
                user_conf_password = confirm_password.getText().toString();


                boolean isEmpty = false;

//                Set error jika terdapat form yang kosong
                if(user_name.isEmpty()){
                    userName.setError("Username Harus Diisi!");
                    isEmpty = true;
                }
                if(user_email.isEmpty()){
                    email.setError("Email Harus Diisi!");
                    isEmpty = true;
                }
                if(user_password.isEmpty()){
                    password.setError("Password Harus Diisi!");
                    isEmpty = true;
                }
                if(user_conf_password.isEmpty()){
                    confirm_password.setError("Password Harus Diisi!");
                    isEmpty = true;
                }


//                Jika password == confirm password maka buat akun
                if(isEmpty == false){
                    if(user_password.equals(user_conf_password)){
                        int check = dbUser.checkAccount(user_name, user_password, user_email);
                        if(check == 0){
                            dbUser.addUserDetail(user_name, user_email, user_password);
                            Toast.makeText(getContext(), "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show();
                            userName.setText("");
                            email.setText("");
                            password.setText("");
                            confirm_password.setText("");
                            if(user_name.equals("admin") && user_password.equals("admin")){
                                Intent intent = new Intent(getActivity(), MainAdmin.class);
                                Session user = new Session(getContext());
                                user.saveSession(user_name);
                                startActivity(intent);
                                getActivity().finish();
                            }else{
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                Session user = new Session(getContext());
                                user.saveSession(user_name);
                                startActivity(intent);
                                getActivity().finish();
                            }


//                            Username Sudah digunakan
                        }else if(check==1){
                            userName.setError("Username sudah digunakan");

//                            Email sudah digunakan
                        }else if(check==3){
                            email.setError("Email sudah digunakan");
                        }

                    }else{
                        confirm_password.setError("PASSWORD TIDAK SESUAI");
                    }
                }
            }
        });

        return view;
    }
}