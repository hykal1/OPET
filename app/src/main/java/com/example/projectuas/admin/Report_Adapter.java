package com.example.projectuas.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.R;

import java.util.ArrayList;

public class Report_Adapter extends RecyclerView.Adapter<Report_Adapter.ListViewHolder> {
    ArrayList<Report_Data> report_data;

    Report_Adapter(ArrayList<Report_Data> report_data){
        this.report_data = report_data;
    }

    @NonNull
    @Override
    public Report_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.report_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Report_Adapter.ListViewHolder holder, int position) {
        Report_Data current = report_data.get(position);
        holder.id.setText(String.valueOf(current.getId()));
        holder.services.setText(current.getServices());
        holder.sum.setText(String.valueOf(current.getSum()));
    }

    @Override
    public int getItemCount() {
        return report_data.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView id, services, sum;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_layanan);
            services = itemView.findViewById(R.id.service_type);
            sum = itemView.findViewById(R.id.count);

        }
    }
}
