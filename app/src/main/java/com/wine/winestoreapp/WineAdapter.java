package com.wine.winestoreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WineAdapter extends RecyclerView.Adapter<WineAdapter.WineViewHolder>{

    private Context context;
    private List<WineModel> wineList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(WineModel wineModel);
    }

    public WineAdapter(Context context, List<WineModel> wineList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.wineList = wineList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public WineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_home_card, parent, false);
        return new WineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WineViewHolder holder, int position) {
        WineModel wineModel = wineList.get(position);
        holder.name.setText(wineModel.getName());
        holder.wineImage.setImageResource(wineModel.getImageResourceId());
        holder.price.setText(wineModel.getPrice());
        holder.bind(wineModel, onItemClickListener);

    }

    @Override
    public int getItemCount() {
        return wineList.size();
    }

    static class WineViewHolder extends RecyclerView.ViewHolder {
        //        ImageView image;
        TextView name, price;
        ImageView wineImage;

        public WineViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtWineName);
            price = itemView.findViewById(R.id.winePrice);
            wineImage = itemView.findViewById(R.id.winePic);
        }

        public void bind(WineModel wineModel, OnItemClickListener onItemClickListener) {
            // Set data to views
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(wineModel));
}
}
}