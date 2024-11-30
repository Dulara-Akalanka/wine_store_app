package com.wine.winestoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        rvCartItems = findViewById(R.id.rvCartItems);
        tvCartTotal = findViewById(R.id.tvCartTotal);
        btnCheckout = findViewById(R.id.btnCheckout);
        btnClearCart = findViewById(R.id.btnClearCart);

        cartItemList = new ArrayList<>();
        cartItemList.add(new CartItem("Red Wine", 3200, 1, R.drawable.w1));
        cartItemList.add(new CartItem("White Wine", 4500, 2, R.drawable.w2));

        cartAdapter = new CartAdapter(cartItemList, this::updateTotalPrice);
        rvCartItems.setLayoutManager(new LinearLayoutManager(this));
        rvCartItems.setAdapter(cartAdapter);

        updateTotalPrice();

        btnCheckout.setOnClickListener(v -> {
        });

        btnClearCart.setOnClickListener(v -> {
            cartItemList.clear();
            cartAdapter.notifyDataSetChanged();
            updateTotalPrice();
        });

        ImageView home = findViewById(R.id.homeIcon);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this,home.class);
                startActivity(intent);
            }
        });

        ImageView category = findViewById(R.id.categoryIcon);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this,category.class);
                startActivity(intent);
            }
        });

        ImageView setting = findViewById(R.id.settingIcon);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this,Settings.class);
                startActivity(intent);
            }
        });

        ImageView cart = findViewById(R.id.cartIcon);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart.this,Cart.class);
                startActivity(intent);
            }
        });
    }

    private void updateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItemList) {
            total += item.getQuantity() * item.getPrice();
        }
        tvCartTotal.setText("Total: Rs." + total);
    }
}
