package com.wine.winestoreapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
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

        int image = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");

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

        plus.setOnClickListener(v -> {
            quantity[0]++;
            txtNum.setText(String.valueOf(quantity[0]));

            plus.animate()
                    .scaleX(1.2f)
                    .scaleY(1.2f)
                    .setDuration(100)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .withEndAction(() -> plus.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(100)
                            .start())
                    .start();
        });

        minus.setOnClickListener(v -> {
            if (quantity[0] > 0) {
                quantity[0]--;
                txtNum.setText(String.valueOf(quantity[0]));

                minus.animate()
                        .scaleX(1.2f)
                        .scaleY(1.2f)
                        .setDuration(100)
                        .setInterpolator(new AccelerateDecelerateInterpolator())
                        .withEndAction(() -> minus.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(100)
                                .start())
                        .start();
            }
        });

        txtNum.setOnClickListener(v -> txtNum.animate()
                .scaleX(1.1f)
                .scaleY(1.1f)
                .setDuration(150)
                .withEndAction(() -> txtNum.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(150)
                        .start())
                .start());
    }
}
