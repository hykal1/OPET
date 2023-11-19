package com.example.projectuas.navbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;
import com.example.projectuas.Session.Session;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    dbTransaksi dbTransaksi;
    RecyclerView rv_vet;
    AdapterHistoryVet adapter;

    Session user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        user = new Session(getContext());
        dbTransaksi = new dbTransaksi(getContext());
        ArrayList<DataHistoryVet> listHistory = dbTransaksi.getHistoryVet(user.getId());
        rv_vet = (RecyclerView) view.findViewById(R.id.type_veterinary);
        adapter = new AdapterHistoryVet(listHistory);
        rv_vet.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_vet.setHasFixedSize(true);
        rv_vet.setAdapter(adapter);

        return view;
    }
}