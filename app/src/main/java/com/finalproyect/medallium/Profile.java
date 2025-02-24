package com.finalproyect.medallium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.finalproyect.medallium.ui.auth.LoginActivity;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        TextView registerClickable = findViewById(R.id.cerrarSesion);

        registerClickable.setOnClickListener(new View.OnClickListener() {
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