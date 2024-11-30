package com.wine.winestoreapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<CartItem> cartItemList;
    private final Runnable onCartUpdated;

    public CartAdapter(List<CartItem> cartItemList, Runnable onCartUpdated) {
        this.cartItemList = cartItemList;
        this.onCartUpdated = onCartUpdated;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem currentItem = cartItemList.get(position);

        holder.ivCartItemImage.setImageResource(currentItem.getImageResource());
        holder.tvCartItemName.setText(currentItem.getName());
        holder.tvCartItemPrice.setText("Rs." + currentItem.getPrice());
        holder.tvCartItemQuantity.setText(String.valueOf(currentItem.getQuantity()));

        // Decrease Quantity
        holder.btnDecreaseQuantity.setOnClickListener(v -> {
            int newQuantity = currentItem.getQuantity() - 1;
            if (newQuantity > 0) {
                currentItem.setQuantity(newQuantity);
                notifyItemChanged(position);
                onCartUpdated.run();
            }
        });

        // Increase Quantity
        holder.btnIncreaseQuantity.setOnClickListener(v -> {
            int newQuantity = currentItem.getQuantity() + 1;
            currentItem.setQuantity(newQuantity);
            notifyItemChanged(position);
            onCartUpdated.run();
        });

        // Remove Item
        holder.btnRemoveItem.setOnClickListener(v -> {
            cartItemList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItemList.size());
            onCartUpdated.run();
        });
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCartItemImage;
        TextView tvCartItemName, tvCartItemPrice, tvCartItemQuantity;
        Button btnDecreaseQuantity, btnIncreaseQuantity, btnRemoveItem;

        public CartViewHolder(View itemView) {
            super(itemView);
            ivCartItemImage = itemView.findViewById(R.id.ivCartItemImage);
            tvCartItemName = itemView.findViewById(R.id.tvCartItemName);
            tvCartItemPrice = itemView.findViewById(R.id.tvCartItemPrice);
            tvCartItemQuantity = itemView.findViewById(R.id.tvCartItemQuantity);
            btnDecreaseQuantity = itemView.findViewById(R.id.btnDecreaseQuantity);
            btnIncreaseQuantity = itemView.findViewById(R.id.btnIncreaseQuantity);
            btnRemoveItem = itemView.findViewById(R.id.btnRemoveItem);
        }
    }
}
