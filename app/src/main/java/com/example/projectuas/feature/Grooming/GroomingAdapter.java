package com.example.projectuas.feature.Grooming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.R;

import java.util.ArrayList;

public class GroomingAdapter extends RecyclerView.Adapter<GroomingAdapter.CardViewViewHolder> {

    private ArrayList<Grooming> listGrooming;
    public GroomingAdapter(ArrayList<Grooming> list) {
        this.listGrooming = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_grooming, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroomingAdapter.CardViewViewHolder holder, int position) {
        Grooming grooming = listGrooming.get(position);

        holder.tvName.setText(grooming.getName_groom());
        holder.tvDesc.setText(grooming.getDesc_groom());
        holder.tvPrice.setText(grooming.getPrice_groom());

    }

    @Override
    public int getItemCount() {
        return listGrooming.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc, tvPrice;
        Button btnBook;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDesc = itemView.findViewById(R.id.tv_item_detail);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
            btnBook = itemView.findViewById(R.id.btn_book);
        }
    }
}
