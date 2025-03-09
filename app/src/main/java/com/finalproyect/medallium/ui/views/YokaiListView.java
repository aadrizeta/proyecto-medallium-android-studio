package com.finalproyect.medallium.ui.views;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.finalproyect.medallium.R;
import com.finalproyect.medallium.databinding.ActivityYokaiListViewBinding;

public class YokaiListView extends AppCompatActivity {

    private ActivityYokaiListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityYokaiListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}