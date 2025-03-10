package com.finalproyect.medallium.ui.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproyect.medallium.BuildConfig;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.databinding.ActivityYokaiListViewBinding;
import com.finalproyect.medallium.domain.entities.DetallesYokai;
import com.finalproyect.medallium.domain.entities.RetrofitClient;
import com.finalproyect.medallium.interfaces.ApiService;
import com.finalproyect.medallium.ui.Adapters.YokaiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YokaiListView extends AppCompatActivity {

    private ActivityYokaiListViewBinding binding;
    private List<DetallesYokai> yokaiList = new ArrayList<>();
    private YokaiAdapter yokaiAdapter;
    private static final String BASE_URL = BuildConfig.BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityYokaiListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String origin = intent.getStringExtra("origin");
        String id = String.valueOf(intent.getIntExtra("id", 0));

        RecyclerView recyclerView = binding.recyclerView;
        yokaiAdapter = new YokaiAdapter(yokaiList);
        recyclerView.setAdapter(yokaiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        switch (origin){
            case "rango":
                switch (id){
                    case "1":
                        loadYokaisByRango(BASE_URL, 1);
                        break;
                    case "2":
                        loadYokaisByRango(BASE_URL, 2);
                        break;
                    case "3":
                        loadYokaisByRango(BASE_URL, 3);
                        break;
                    case "4":
                        loadYokaisByRango(BASE_URL, 4);
                        break;
                    case "5":
                        loadYokaisByRango(BASE_URL, 5);
                        break;
                    case "6":
                        loadYokaisByRango(BASE_URL, 6);
                        break;
                    default:
                        Toast.makeText(this, "Error 2", Toast.LENGTH_SHORT).show();
                        break;
                }
            case "elementos":
                switch (id){
                    case "1":
                        loadYokaisByElemento(BASE_URL, 1);
                        break;
                    case "2":
                        loadYokaisByElemento(BASE_URL, 2);
                        break;
                    case "3":
                        loadYokaisByElemento(BASE_URL, 3);
                        break;
                    case "4":
                        loadYokaisByElemento(BASE_URL, 4);
                        break;
                    case "5":
                        loadYokaisByElemento(BASE_URL, 5);
                        break;
                    case "6":
                        loadYokaisByElemento(BASE_URL, 6);
                        break;
                    case "7":
                        loadYokaisByElemento(BASE_URL, 7);
                        break;
                    case "8":
                        loadYokaisByElemento(BASE_URL, 8);
                        break;
                    default:
                        Toast.makeText(this, "Error 3", Toast.LENGTH_SHORT).show();
                        break;
                }
            case "tribus":
                switch (id){
                    case "2":
                        loasYokaisByTribu(BASE_URL, 2);
                        break;
                    case "3":
                        loasYokaisByTribu(BASE_URL, 3);
                        break;
                    case "4":
                        loasYokaisByTribu(BASE_URL, 4);
                        break;
                    case "5":
                        loasYokaisByTribu(BASE_URL, 5);
                        break;
                    case "6":
                        loasYokaisByTribu(BASE_URL, 6);
                        break;
                    case "7":
                        loasYokaisByTribu(BASE_URL, 7);
                        break;
                    case "8":
                        loasYokaisByTribu(BASE_URL, 8);
                        break;
                    case "9":
                        loasYokaisByTribu(BASE_URL, 9);
                        break;
                    case "10":
                        loasYokaisByTribu(BASE_URL, 10);
                        break;
                    default:
                        Toast.makeText(this, "Error 4", Toast.LENGTH_SHORT).show();
                        break;
                }
            default:
                Toast.makeText(this, "Error 1", Toast.LENGTH_SHORT).show();
                break;
        }

    }
    private void loadYokaisByRango(String url, int rango){
        ApiService apiService = RetrofitClient.getClient(url).create(ApiService.class);
        Call<List<DetallesYokai>> call = apiService.getByRango(rango);
        call.enqueue(new Callback<List<DetallesYokai>>() {
            @Override
            public void onResponse(Call<List<DetallesYokai>> call, Response<List<DetallesYokai>> response) {
                yokaiList.clear();
                yokaiList.addAll(response.body());
                yokaiAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<DetallesYokai>> call, Throwable throwable) {
            }
        });
    }
    private void loadYokaisByElemento(String ur, int elemento){
        ApiService apiService = RetrofitClient.getClient(ur).create(ApiService.class);
        Call<List<DetallesYokai>> call = apiService.getByElemento(elemento);
        call.enqueue(new Callback<List<DetallesYokai>>() {
            @Override
            public void onResponse(Call<List<DetallesYokai>> call, Response<List<DetallesYokai>> response) {
                yokaiList.clear();
                yokaiList.addAll(response.body());
                yokaiAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<DetallesYokai>> call, Throwable throwable) {
            }
        });
    }
    private void loasYokaisByTribu(String url, int tribu){
        ApiService apiService = RetrofitClient.getClient(url).create(ApiService.class);
        Call<List<DetallesYokai>> call = apiService.getByTribu(tribu);
        call.enqueue(new Callback<List<DetallesYokai>>() {
            @Override
            public void onResponse(Call<List<DetallesYokai>> call, Response<List<DetallesYokai>> response) {
                yokaiList.clear();
                yokaiList.addAll(response.body());
                yokaiAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<DetallesYokai>> call, Throwable throwable) {
            }
        });
    }
}