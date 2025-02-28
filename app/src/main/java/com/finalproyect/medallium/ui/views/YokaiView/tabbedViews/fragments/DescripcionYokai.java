package com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalproyect.medallium.R;

public class DescripcionYokai extends Fragment {

    private TextView descripcionYokai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_descripcion_yokai, container, false);

        descripcionYokai = view.findViewById(R.id.descripcion_yokai);
        descripcionYokai.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
    public void setDescripcion(String descripcion) {
        descripcionYokai.setText(descripcion);
    }
}