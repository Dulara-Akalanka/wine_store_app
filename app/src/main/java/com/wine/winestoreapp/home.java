package com.wine.winestoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;  // Import the View class
import android.widget.ImageView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView itemViews = findViewById(R.id.items);
        itemViews.setLayoutManager(new GridLayoutManager(this, 2));;

        List<WineModel> wines = new ArrayList<>();
        wines.add(new WineModel("Riesling ", R.drawable.w1, "Rs. 6200"));
        wines.add(new WineModel("Pinot", R.drawable.w2, "Rs. 7200"));
        wines.add(new WineModel("Cabernet", R.drawable.w3, "Rs. 3200"));
        wines.add(new WineModel("Sauvignon", R.drawable.w4, "Rs. 5200"));
        wines.add(new WineModel("Merlot", R.drawable.w5, "Rs. 9200"));
        wines.add(new WineModel("Chardonnay", R.drawable.w6, "Rs. 5200"));

        WineAdapter adapter = new WineAdapter(this, wines, new WineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WineModel wineModel) {
                // Create an intent to navigate to WineActivity
                Intent intent = new Intent(home.this, ItemView.class);
                intent.putExtra("image", wineModel.getImageResourceId());
                intent.putExtra("name", wineModel.getName());
                intent.putExtra("price", wineModel.getPrice());
                startActivity(intent);
            }
        });
        itemViews.setAdapter(adapter);


        ImageView home = findViewById(R.id.homeIcon);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,home.class);
                startActivity(intent);
            }
        });

        ImageView category = findViewById(R.id.categoryIcon);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,category.class);
                startActivity(intent);
            }
        });

        ImageView setting = findViewById(R.id.settingIcon);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,Settings.class);
                startActivity(intent);
            }
        });

        ImageView cart = findViewById(R.id.cartIcon);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,Cart.class);
                startActivity(intent);
            }
        });
    }

}
