package com.example.projectuas.feature.Veterinary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.projectuas.MainActivity;
import com.example.projectuas.R;

import java.util.ArrayList;

public class VeterinaryAdapter extends RecyclerView.Adapter<VeterinaryAdapter.CardViewViewHolderVet> {

    private ArrayList<Veterinary> listVeterinary;
    public VeterinaryAdapter(ArrayList<Veterinary> list) {
        this.listVeterinary = list;
    }

    public OnItemClickCallBack onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallBack onItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack;
    }

    @NonNull
    @Override
    public VeterinaryAdapter.CardViewViewHolderVet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_veterinary, parent, false);
        return new VeterinaryAdapter.CardViewViewHolderVet(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VeterinaryAdapter.CardViewViewHolderVet holder, int position) {
        Veterinary veterinary = listVeterinary.get(position);

        Glide.with(holder.itemView.getContext()).load(veterinary.getPhoto()).apply(new RequestOptions().override(350, 550)).into(holder.imgPhoto);
        holder.tvName.setText(veterinary.getName_vet());
        holder.tvDesc.setText(veterinary.getDesc_vet());
        holder.tvPrice.setText(veterinary.getPrice_vet());
        holder.btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veterinary clicked = listVeterinary.get(holder.getAdapterPosition());
                onItemClickCallBack.onItemClicked(clicked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listVeterinary.size();
    }

    public class CardViewViewHolderVet extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc, tvPrice;
        ImageView imgPhoto;
        Button btnConsult;

        public CardViewViewHolderVet(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvName = itemView.findViewById(R.id.tv_vet_name);
            tvDesc = itemView.findViewById(R.id.tv_vet_detail);
            tvPrice = itemView.findViewById(R.id.tv_vet_price);
            btnConsult = itemView.findViewById(R.id.btn_consult);
        }
    }

    public interface OnItemClickCallBack{
        void onItemClicked(Veterinary clicked);
    }
}
