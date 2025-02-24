package com.finalproyect.medallium.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.finalproyect.medallium.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        TextView loginClickable = findViewById(R.id.login_clickable);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();
                launchLogin();
            }
        });

        loginClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLogin();
            }
        });

    }

    public void launchLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}

