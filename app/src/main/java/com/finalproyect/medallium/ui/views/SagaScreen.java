package com.finalproyect.medallium.ui.views;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.finalproyect.medallium.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class SagaScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saga_screen);

        ImageView atrasButton = (ImageView) findViewById(R.id.backButton);
        ImageView yokaiwatch1 = (ImageView) findViewById(R.id.yokaiwatch1);
        ImageView yokaiwatch2 = (ImageView) findViewById(R.id.yokaiwatch2);
        ImageView yokaiwatch3 = (ImageView) findViewById(R.id.yokaiwatch3);

        LinearLayout mainContainer = (LinearLayout) findViewById(R.id.mainContainer);
        LayoutInflater inflater = LayoutInflater.from(this);

        yokaiwatch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View juegoView = inflater.inflate(R.layout.saga_cardview, mainContainer, false);
                TextView descripcion = juegoView.findViewById(R.id.descripcion);
                descripcion.setMovementMethod(new ScrollingMovementMethod());
                AlertDialog alertDialog = new MaterialAlertDialogBuilder(SagaScreen.this)
                        .setView(juegoView)
                        .create();
                alertDialog.show();
            }
        });

        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SagaScreen.this.finish();
            }
        });
    }
}