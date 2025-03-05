package com.finalproyect.medallium.ui.views.Tribus;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproyect.medallium.BuildConfig;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.databinding.ActivityTribusScreenBinding;
import com.finalproyect.medallium.domain.entities.RetrofitClient;
import com.finalproyect.medallium.domain.entities.Tribus;
import com.finalproyect.medallium.interfaces.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TribusScreen extends AppCompatActivity {

    private ActivityTribusScreenBinding binding;
    private TribuAdapter tribuAdapter;
    private List<Tribus> tribusList = new ArrayList<>();
    private String BASE_URL = BuildConfig.BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityTribusScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        tribuAdapter = new TribuAdapter(tribusList);
        RecyclerView recyclerView = binding.recyclerViewPopulares;
        recyclerView.setAdapter(tribuAdapter);
        if (tribuAdapter == null){
            Toast.makeText(this, "adaptador nulo", Toast.LENGTH_SHORT).show();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView atrasButton = (ImageView) findViewById(R.id.backButton);
        loadTribus(BASE_URL);
        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TribusScreen.this.finish();
            }
        });
    }
    private void loadTribus(String url){
        ApiService apiService = RetrofitClient.getClient(url).create(ApiService.class);
        Call<List<Tribus>> call = apiService.getTribus();

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Tribus>> call, Response<List<Tribus>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Tribus recibidas: ", response.body().toString());
                    tribusList.clear();
                    tribusList.addAll(response.body());
                    tribuAdapter.notifyDataSetChanged();
                } else {
                    Log.e("Error en la respuesta de la API: ", response.message());
                    Toast.makeText(TribusScreen.this, "Error al cargar las tribus", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Tribus>> call, Throwable throwable) {
                Toast.makeText(TribusScreen.this, "Error de conexión:", Toast.LENGTH_SHORT).show();
                Log.e("HomeFragment", "Error en la llamada a la API: " + throwable.getMessage());
            }
        });
    }
}