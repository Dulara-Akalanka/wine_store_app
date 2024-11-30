package com.wine.winestoreapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


 public class ItemView extends AppCompatActivity {


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         EdgeToEdge.enable(this);
         setContentView(R.layout.activity_item_view);
         ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
             Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
             v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
             return insets;
         });

         // Get data from Intent
         int image = getIntent().getIntExtra("image",0);
         String name = getIntent().getStringExtra("name");
         String price = getIntent().getStringExtra("price");

         // Bind data to views
         ImageView imageView2 = findViewById(R.id.imageView);
         TextView nameView2 = findViewById(R.id.txtname);
         TextView priceView2 = findViewById(R.id.txtPrice);

         imageView2.setImageResource(image);
         nameView2.setText(name);
         priceView2.setText(price);

         TextView txtNum = findViewById(R.id.txtNum);
         ImageView plus = findViewById(R.id.plus);
         ImageView minus = findViewById(R.id.minus);

         int[] quantity = {1};

         plus.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 quantity[0]++; // Increment quantity
                 txtNum.setText(String.valueOf(quantity[0])); // Update TextView
             }
         });

         minus.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (quantity[0] > 0) { // Ensure quantity does not go below 0
                     quantity[0]--;
                     txtNum.setText(String.valueOf(quantity[0])); // Update TextView
                 }
             }
         });

     }
}


