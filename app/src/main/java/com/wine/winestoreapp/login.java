package com.wine.winestoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        findViewById(R.id.main).startAnimation(fadeIn);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleUp = AnimationUtils.loadAnimation(login.this, R.anim.scale_up);
                v.startAnimation(scaleUp);

                v.postDelayed(() -> {
                    Intent intent = new Intent(login.this, home.class);
                    startActivity(intent);
                }, 200);
            }
        });

        TextView toRegister = findViewById(R.id.txttoregister);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleUp = AnimationUtils.loadAnimation(login.this, R.anim.scale_up);
                v.startAnimation(scaleUp);

                v.postDelayed(() -> {
                    Intent intent = new Intent(login.this, register.class);
                    startActivity(intent);
                }, 200);
            }
        });
    }
}
