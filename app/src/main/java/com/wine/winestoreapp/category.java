package com.wine.winestoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView red = findViewById(R.id.redswip);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,SingleCategory.class);
                startActivity(intent);
            }
        });

        ImageView white = findViewById(R.id.whiteswip);
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,SingleCategory.class);
                startActivity(intent);
            }
        });

        ImageView rose = findViewById(R.id.roseswip);
        rose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,SingleCategory.class);
                startActivity(intent);
            }
        });

        ImageView home = findViewById(R.id.homeIcon);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,home.class);
                startActivity(intent);
            }
        });

        ImageView category = findViewById(R.id.categoryIcon);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,category.class);
                startActivity(intent);
            }
        });

        ImageView setting = findViewById(R.id.settingIcon);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,Settings.class);
                startActivity(intent);
            }
        });

        ImageView cart = findViewById(R.id.cartIcon);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(category.this,Cart.class);
                startActivity(intent);
            }
        });
    }
}