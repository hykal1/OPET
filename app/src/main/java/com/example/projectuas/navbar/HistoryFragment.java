package com.example.projectuas.navbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    dbTransaksi dbTransaksi;
    RecyclerView rv_vet;
    AdapterHistoryVet adapter;
    ArrayList<DataHistoryVet> listHistory;
    RecyclerView rv_groom;
    AdapterHistoryGroom adapter2;
    ArrayList<DataHistoryGroom> listHistory2;

    Session user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        user = new Session(getContext());
        dbTransaksi = new dbTransaksi(getContext());
        listHistory = dbTransaksi.getHistoryVet(user.getId());
        rv_vet = (RecyclerView) view.findViewById(R.id.type_veterinary);
        adapter = new AdapterHistoryVet(listHistory, getContext());
        rv_vet.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_vet.setHasFixedSize(true);
        rv_vet.setAdapter(adapter);

        rv_groom = view.findViewById(R.id.type_grooming);
        listHistory2 = dbTransaksi.getHistoryGroom(user.getId());
        adapter2 = new AdapterHistoryGroom(listHistory2, getContext());
        rv_groom.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_groom.setHasFixedSize(true);
        rv_groom.setAdapter(adapter2);
        return view;
    }
}