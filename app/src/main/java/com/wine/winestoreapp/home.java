package com.wine.winestoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;  // Import the View class

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }

    // Move this method outside of onCreate
    public void onCardClick(View view) {
        // Get the data to send
        String productName = view.findViewById(R.id.product_name).getText().toString();
        String productPrice = "$24.99";
        int productImage = R.drawable.w1;

        // Create an Intent to navigate to the second activity
        Intent intent = new Intent(home.this, ItemView.class);

        // Put the data in the Intent
        intent.putExtra("product_name", productName);
        intent.putExtra("product_price", productPrice);
        intent.putExtra("product_image", productImage);

        // Start the second activity
        startActivity(intent);
    }
}
