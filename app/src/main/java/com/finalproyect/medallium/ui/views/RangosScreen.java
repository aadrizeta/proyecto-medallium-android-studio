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
import com.finalproyect.medallium.databinding.ActivityRangosScreenBinding;
import com.finalproyect.medallium.domain.entities.Rango;
import com.finalproyect.medallium.domain.entities.RetrofitClient;
import com.finalproyect.medallium.interfaces.ApiService;
import com.finalproyect.medallium.ui.Adapters.RangosAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RangosScreen extends AppCompatActivity {

    private ActivityRangosScreenBinding binding;
    private RangosAdapter adapter;
    private List<Rango> rangoList = new ArrayList<>();
    private String BASE_URL = BuildConfig.BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityRangosScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView atrasButton = (ImageView) findViewById(R.id.backButton);

        adapter = new RangosAdapter(rangoList);
        RecyclerView recyclerView = binding.recyclerViewRangos;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadRangos(BASE_URL);

        atrasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RangosScreen.this.finish();
            }
        });
    }
    private void loadRangos(String url){
        ApiService apiService = RetrofitClient.getClient(url).create(ApiService.class);
        Call<List<Rango>> call = apiService.getRango();
        call.enqueue(new Callback<List<Rango>>() {
            @Override
            public void onResponse(Call<List<Rango>> call, Response<List<Rango>> response) {
                if (response.isSuccessful() && response.body() != null){
                    rangoList.clear();
                    rangoList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e("Error en la respuesta de la API: ", response.message());
                    Toast.makeText(RangosScreen.this, "Error al cargar los rangos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Rango>> call, Throwable throwable) {
                Toast.makeText(RangosScreen.this, "Error de conexión:", Toast.LENGTH_SHORT).show();
                Log.e("HomeFragment", "Error en la llamada a la API: " + throwable.getMessage());
            }
        });
    }
}