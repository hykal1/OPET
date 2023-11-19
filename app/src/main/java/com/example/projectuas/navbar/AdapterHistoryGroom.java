package com.example.projectuas.navbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.R;

import java.util.ArrayList;

public class AdapterHistoryGroom extends RecyclerView.Adapter<AdapterHistoryGroom.ListViewRecycler> {

    ArrayList<DataHistoryGroom> listData;
    Context context;
    AdapterHistoryGroom(ArrayList<DataHistoryGroom> listData, Context context){
        this.listData = listData;
        this.context = context;
    }
    @NonNull
    @Override
    public AdapterHistoryGroom.ListViewRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_grooming, parent, false);
        return new ListViewRecycler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHistoryGroom.ListViewRecycler holder, int position) {
        DataHistoryGroom current = listData.get(position);
        holder.tv_name.setText(current.getNama());
        holder.tv_status.setText(current.getStatus());
        holder.tv_price.setText(String.valueOf(current.getPrice()));
        holder.tv_desc.setText(current.getDesc());
        if(current.getStatus().equals("complete")){
            holder.tv_status.setTextColor(ContextCompat.getColor(context, R.color.green));
        }else {
            holder.tv_status.setTextColor(ContextCompat.getColor(context, R.color.red));
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ListViewRecycler extends RecyclerView.ViewHolder{
        TextView tv_name, tv_status, tv_price, tv_desc;
        public ListViewRecycler(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_item_name);
            tv_desc = itemView.findViewById(R.id.tv_item_detail);
            tv_price = itemView.findViewById(R.id.tv_item_price);
            tv_status = itemView.findViewById(R.id.tv_item_status);

        }
    }
}
