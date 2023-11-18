package com.example.projectuas.feature.accessories;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectuas.R;

import java.util.List;

public class AccessoriesAdapter extends RecyclerView.Adapter<AccessoriesAdapter.ViewHolder> {

    private List<Accessories> accessoriesList;
    private Context context;

    public AccessoriesAdapter(List<Accessories> accessoriesList, Context context) {
        this.accessoriesList = accessoriesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_toys, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Accessories accessories = accessoriesList.get(position);

        holder.imageView.setImageResource(accessories.getImageResourceId());
        holder.textViewName.setText(accessories.getName());
        holder.textViewDesc.setText(accessories.getDesc());

        holder.textViewLinkTokped.setOnClickListener(view -> {
            String url = accessories.getLinkTokped();
            openLinkInBrowser(url);
        });

        holder.textViewLinkShopee.setOnClickListener(view -> {
            String url = accessories.getLinkShopee();
            openLinkInBrowser(url);
        });
    }

    private void openLinkInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return accessoriesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName;
        private TextView textViewDesc;
        private TextView textViewLinkTokped;
        private TextView textViewLinkShopee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            textViewLinkTokped = itemView.findViewById(R.id.textViewTokped);
            textViewLinkShopee = itemView.findViewById(R.id.textViewShopee);

        }
    }
}