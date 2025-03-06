package com.finalproyect.medallium.ui.views;

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
import com.finalproyect.medallium.databinding.ActivityElementosScreenBinding;
import com.finalproyect.medallium.domain.entities.Elemento;
import com.finalproyect.medallium.domain.entities.RetrofitClient;
import com.finalproyect.medallium.interfaces.ApiService;
import com.finalproyect.medallium.ui.Adapters.ElementosAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElementosScreen extends AppCompatActivity {

    private ActivityElementosScreenBinding binding;
    private ElementosAdapter adapter;
    private List<Elemento> elementoList = new ArrayList<>();
    private String BASE_URL = BuildConfig.BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityElementosScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView atrasButton = (ImageView) findViewById(R.id.backButton);

        adapter = new ElementosAdapter(elementoList);
        RecyclerView recyclerView = binding.recyclerViewElementos;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadElementos(BASE_URL);

        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElementosScreen.this.finish();
            }
        });
    }
    private void loadElementos(String url){
        ApiService apiService = RetrofitClient.getClient(url).create(ApiService.class);
        Call<List<Elemento>> call = apiService.getAllElementos();
        call.enqueue(new Callback<List<Elemento>>() {
            @Override
            public void onResponse(Call<List<Elemento>> call, Response<List<Elemento>> response) {
                if (response.isSuccessful() && response.body() != null){
                    elementoList.clear();
                    elementoList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("Error en la respuesta de la API: ", response.message());
                    Toast.makeText(ElementosScreen.this, "Error al cargar los elementos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Elemento>> call, Throwable throwable) {
                Toast.makeText(ElementosScreen.this, "Error de conexión:", Toast.LENGTH_SHORT).show();
                Log.e("HomeFragment", "Error en la llamada a la API: " + throwable.getMessage());
            }
        });
    }
}