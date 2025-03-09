package com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalproyect.medallium.R;

public class EstadisticasYokai extends Fragment {

    TextView hp;
    TextView fuerza;
    TextView esp;
    TextView defensa;
    TextView velocidad;
    TextView total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estadisticas_yokai, container, false);

        hp = view.findViewById(R.id.hp);
        fuerza = view.findViewById(R.id.fuerza);
        esp = view.findViewById(R.id.esp);
        defensa = view.findViewById(R.id.defensa);
        velocidad = view.findViewById(R.id.velocidad);
        return view;
    }

    public void setHp(int puntos) {
        hp.setText(String.valueOf(puntos));
    }

    public void setFuerza(int puntos) {
        fuerza.setText(String.valueOf(puntos));
    }

    public void setEsp(int puntos) {
        esp.setText(String.valueOf(puntos));
    }

    public void setDefensa(int puntos) {
        defensa.setText(String.valueOf(puntos));
    }

    public void setVelocidad(int puntos) {
        velocidad.setText(String.valueOf(puntos));
    }

    public void setTotal(int puntos) {
        total.setText(String.valueOf(puntos));
    }
}