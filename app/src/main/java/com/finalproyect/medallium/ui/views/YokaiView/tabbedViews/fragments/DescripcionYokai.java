package com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.finalproyect.medallium.R;

public class DescripcionYokai extends Fragment {
    public TextView descripcionYokai;
    public ImageView medalla;
    public TextView comidaYkw1;
    public TextView comidaYkw2;
    public TextView comidaYkw3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_descripcion_yokai, container, false);

        descripcionYokai = view.findViewById(R.id.descripcion_yokai);
        descripcionYokai.setMovementMethod(new ScrollingMovementMethod());
        medalla = view.findViewById(R.id.medallaImage);
        comidaYkw1 = view.findViewById(R.id.comida_ykw1);
        comidaYkw2 = view.findViewById(R.id.comida_ykw2);
        comidaYkw3 = view.findViewById(R.id.comida_ykw3);

        return view;
    }
    public void setDescripcion(String descripcion) {
        descripcionYokai.setText(descripcion);
    }
    public void setMedallaImage(String image) {
        Glide.with(getContext()).load(image).into(medalla);

    }

    public void setComidaYkw2(String comida) {
        comidaYkw2.setText(comida);
    }

    public void setComidaYkw1(String comida) {
        comidaYkw1.setText(comida);
    }

    public void setComidaYkw3(String comida) {
        comidaYkw3.setText(comida);
    }
}