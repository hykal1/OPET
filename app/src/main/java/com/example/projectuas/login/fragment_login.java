package com.example.projectuas.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectuas.DataBase.dbUser;
import com.example.projectuas.MainActivity;
import com.example.projectuas.admin.MainAdmin;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;
import com.example.projectuas.object.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_login extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_login.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_login newInstance(String param1, String param2) {
        fragment_login fragment = new fragment_login();
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

    private EditText userName, password;
    private Button login;
    dbUser dbUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        userName = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        login = view.findViewById(R.id.login_btn);
        dbUser = new dbUser(getContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name, user_password;
                user_name = userName.getText().toString();
                user_password = password.getText().toString();

                boolean isEmpty = false;
//                Set error jika terdapat form yang kosong
                if(user_name.isEmpty()){
                    userName.setError("Username Harus Diisi!");
                    isEmpty = true;
                }
                if(user_password.isEmpty()){
                    password.setError("Password Harus Diisi!");
                }

//                Jika Tidak kosong maka lakukan autentikasi
                if(isEmpty == false){
                    int check = dbUser.loginAuthentication(user_name, user_password);
                    if(check==1){
                        User online = dbUser.getAccount(user_name, user_password);
                        Toast.makeText(getContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                        if(user_name.equals("admin") && user_password.equals("admin")){
                            Intent intent = new Intent(getActivity(), MainAdmin.class);
                            Session user = new Session(getContext());
                            user.saveSession(online.getId(), online.getUsername(), online.getEmail(), online.getPassword());
                            startActivity(intent);
                            getActivity().finish();
                        }else{
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            Session user = new Session(getContext());
                            user.saveSession(online.getId(), online.getUsername(), online.getEmail(), online.getPassword());
                            startActivity(intent);
                            getActivity().finish();
                        }
                    }else if (check==2){
                        password.setError("Password Salah!");
                    }else if(check==0){
                        Toast.makeText(getContext(), "Akun tidak ditemukan!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }
}