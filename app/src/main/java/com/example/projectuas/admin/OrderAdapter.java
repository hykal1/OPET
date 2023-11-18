package com.example.projectuas.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.DataBase.dbTransaksi;
import com.example.projectuas.R;

import java.util.ArrayList;




public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ListViewHolder> {

    public ArrayList<OrderData> orderDataList;
    dbTransaksi dbTransaksi;

    OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    OrderAdapter(ArrayList<OrderData> orderDataList){
        this.orderDataList = orderDataList;
    }

    @NonNull
    @Override
    public OrderAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ListViewHolder holder, int position) {
        OrderData current = orderDataList.get(position);
        holder.number.setText(String.valueOf(current.getId()));
        holder.services.setText(current.getServices());
        holder.price.setText(String.valueOf(current.getPrices()));
        holder.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallBack.onItemClicked(orderDataList.get(holder.getAdapterPosition()));
            }
        });
    }

    public void updateData(ArrayList<OrderData> newData){
        this.orderDataList.clear();
        orderDataList.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return orderDataList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView number, services, price;
        Button confirm;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.Id);
            services = itemView.findViewById(R.id.service_type);
            price = itemView.findViewById(R.id.price);
            confirm = itemView.findViewById(R.id.confirm);
        }
    }

    public interface OnItemClickCallBack{
        void onItemClicked(OrderData data);
    }
}
