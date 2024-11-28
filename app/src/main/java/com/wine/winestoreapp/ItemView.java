package com.wine.winestoreapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


 public class ItemView extends AppCompatActivity {

    private ImageView imageView;
    private TextView txtname, txtPrice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        // Get the views
        imageView = findViewById(R.id.imageView);
        txtname = findViewById(R.id.txtname);
        txtPrice = findViewById(R.id.txtPrice);

        // Get the data from the Intent
        Intent intent = getIntent();
        String productName = intent.getStringExtra("product_name");
        String productPrice = intent.getStringExtra("product_price");
        int productImage = intent.getIntExtra("product_image", 0);

        // Set the data to the views
        txtname.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(productImage);
    }
}


