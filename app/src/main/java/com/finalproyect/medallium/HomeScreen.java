package com.finalproyect.medallium;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);

        CardView cardViewLogo = findViewById(R.id.cardViewLogo);
        Button tribusButton = findViewById(R.id.tribus_button);
        Button elementosButton = findViewById(R.id.elementos_button);
        Button rangosButton = findViewById(R.id.rangos_button);
        Button sagaButton = findViewById(R.id.saga_button);

        cardViewLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchProfile();
            }
        });

        tribusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchTribus();
            }
        });

        elementosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchElementos();
            }
        });

        rangosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRangos();
            }
        });

        sagaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSaga();
            }
        });
    }

    public void launchProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void launchRangos() {
        Intent intent = new Intent(this, RangosScreen.class);
        startActivity(intent);
    }

    public void launchTribus() {
        Intent intent = new Intent(this, TribusScreen.class);
        startActivity(intent);
    }

    public void launchSaga() {
        Intent intent = new Intent(this, SagaScreen.class);
        startActivity(intent);
    }

    public void launchElementos() {
        Intent intent = new Intent(this, ElementosScreen.class);
        startActivity(intent);
    }
}