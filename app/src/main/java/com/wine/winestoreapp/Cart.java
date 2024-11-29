package com.wine.winestoreapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private RecyclerView rvCartItems;
    private CartAdapter cartAdapter;
    private ArrayList<CartItem> cartItemList;
    private TextView tvCartTotal;
    private Button btnCheckout, btnClearCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize Views
        rvCartItems = findViewById(R.id.rvCartItems);
        tvCartTotal = findViewById(R.id.tvCartTotal);
        btnCheckout = findViewById(R.id.btnCheckout);
        btnClearCart = findViewById(R.id.btnClearCart);

        // Initialize Cart Data
        cartItemList = new ArrayList<>();
        cartItemList.add(new CartItem("Red Wine", 3200, 1, R.drawable.w1));
        cartItemList.add(new CartItem("White Wine", 4500, 2, R.drawable.w1));

        // Set up RecyclerView
        cartAdapter = new CartAdapter(cartItemList, this::updateTotalPrice);
        rvCartItems.setLayoutManager(new LinearLayoutManager(this));
        rvCartItems.setAdapter(cartAdapter);

        // Update Total Price
        updateTotalPrice();

        // Checkout Button Click
        btnCheckout.setOnClickListener(v -> {
            // Handle checkout logic here
        });

        // Clear Cart Button Click
        btnClearCart.setOnClickListener(v -> {
            cartItemList.clear();
            cartAdapter.notifyDataSetChanged();
            updateTotalPrice();
        });
    }

    // Update Total Price Method
    private void updateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItemList) {
            total += item.getQuantity() * item.getPrice();
        }
        tvCartTotal.setText("Total: $" + total);
    }
}
