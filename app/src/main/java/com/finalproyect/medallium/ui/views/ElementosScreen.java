package com.finalproyect.medallium.ui.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.finalproyect.medallium.Ejemplo;
import com.finalproyect.medallium.HomeScreen;
import com.finalproyect.medallium.R;

public class ElementosScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_elementos_screen);

        ImageView atrasButton = (ImageView) findViewById(R.id.backButton);

        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElementosScreen.this.finish();
            }
        });
    }
}