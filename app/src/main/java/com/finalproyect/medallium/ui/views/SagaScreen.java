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

        yokaiwatch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion(yokaiwatch1);
            }
        });
        yokaiwatch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion(yokaiwatch2);
            }
        });
        yokaiwatch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarInformacion(yokaiwatch3);
            }
        });

        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SagaScreen.this.finish();
            }
        });
    }
    public void mostrarInformacion(ImageView juego){
        LinearLayout mainContainer = findViewById(R.id.mainContainer);
        LayoutInflater inflater = LayoutInflater.from(this);
        View juegoView = inflater.inflate(R.layout.saga_cardview, mainContainer, false);
        ImageView logoJuego = juegoView.findViewById(R.id.logo_juego);
        TextView nombreJuego = juegoView.findViewById(R.id.nombre_juego);
        TextView fechaLanzamiento = juegoView.findViewById(R.id.fecha_lanzamiento);
        TextView plataformas = juegoView.findViewById(R.id.plataformas);
        TextView descripcion = juegoView.findViewById(R.id.descripcion);
        descripcion.setMovementMethod(new ScrollingMovementMethod());

        if (juego.getId() == R.id.yokaiwatch1) {
            logoJuego.setImageResource(R.drawable.saga_logo1);
            nombreJuego.setText(R.string.YKW1_name);
            fechaLanzamiento.setText(R.string.YKW1_fecha);
            plataformas.setText(R.string.YKW1_plataformas);
            descripcion.setText(R.string.YKW1_description);
        }
        else if (juego.getId() == R.id.yokaiwatch2) {
            logoJuego.setImageResource(R.drawable.saga_logo2);
            nombreJuego.setText(R.string.YKW2_name);
            fechaLanzamiento.setText(R.string.YKW2_fecha);
            plataformas.setText(R.string.YKW2_plataformas);
            descripcion.setText(R.string.YKW2_description);
        }
        else if (juego.getId() == R.id.yokaiwatch3) {
            logoJuego.setImageResource(R.drawable.saga_logo3);
            nombreJuego.setText(R.string.YKW3_name);
            fechaLanzamiento.setText(R.string.YKW3_fecha);
            plataformas.setText(R.string.YKW3_plataformas);
            descripcion.setText(R.string.YKW3_description);
        }
        AlertDialog alertDialog = new MaterialAlertDialogBuilder(SagaScreen.this)
                .setView(juegoView)
                .create();
        alertDialog.show();
    }
}