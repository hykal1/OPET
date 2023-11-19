package com.example.projectuas.navbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projectuas.R;

import java.util.ArrayList;

public class AdapterHistoryVet extends RecyclerView.Adapter<AdapterHistoryVet.ListViewRecycler> {

    ArrayList<DataHistoryVet> dataHistoryVets;
    Context context;
    AdapterHistoryVet(ArrayList<DataHistoryVet> dataHistoryVets, Context context){
        this.dataHistoryVets = dataHistoryVets;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterHistoryVet.ListViewRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_veterinary, parent, false);
        return new ListViewRecycler(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull AdapterHistoryVet.ListViewRecycler holder, int position) {
        DataHistoryVet current = dataHistoryVets.get(position);
        Glide.with(holder.itemView.getContext()).load(current.getGambar()).apply(new RequestOptions().override(72,94)).into(holder.gambar);
        holder.tv_status.setText(current.getStatus());
        holder.tv_name.setText(current.getNama());
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
        return dataHistoryVets.size();
    }

    public class ListViewRecycler extends RecyclerView.ViewHolder{
        TextView tv_name, tv_desc, tv_status, tv_price;
        ImageView gambar;
        public ListViewRecycler(@NonNull View itemView) {
            super(itemView);
            tv_desc = itemView.findViewById(R.id.tv_vet_detail);
            tv_name = itemView.findViewById(R.id.tv_vet_name);
            tv_price = itemView.findViewById(R.id.tv_vet_price);
            tv_status = itemView.findViewById(R.id.tv_item_status_veterinary);
            gambar = itemView.findViewById(R.id.img_photo);
        }
    }
}
