package com.example.projectuas.feature.food;

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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private List<Food> foodList;
    private Context context;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foodList.get(position);

        holder.imageView.setImageResource(food.getImageResourceId());
        holder.textViewName.setText(food.getName());
        holder.textViewDesc.setText(food.getDesc());

        holder.textViewLinkTokped.setOnClickListener(view -> {
            String url = food.getLinkTokped();
            openLinkInBrowser(url);
        });

        holder.textViewLinkShopee.setOnClickListener(view -> {
            String url = food.getLinkShopee();
            openLinkInBrowser(url);
        });
    }

    private void openLinkInBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
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
