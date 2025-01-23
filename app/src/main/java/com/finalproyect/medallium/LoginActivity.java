package com.finalproyect.medallium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        TextView registerClickable = findViewById(R.id.register_clickable);

        registerClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRegister();

            }
        });
    }
    public void launchRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}