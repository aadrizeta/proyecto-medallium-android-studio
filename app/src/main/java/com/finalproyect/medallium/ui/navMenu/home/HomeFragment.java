package com.finalproyect.medallium.ui.navMenu.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproyect.medallium.Adapter.YokaiAdapter;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.databinding.FragmentHomeBinding;
import com.finalproyect.medallium.domain.entities.DetallesYokai;
import com.finalproyect.medallium.domain.entities.RetrofitClient;
import com.finalproyect.medallium.interfaces.ApiService;
import com.finalproyect.medallium.ui.views.ElementosScreen;
import com.finalproyect.medallium.ui.views.RangosScreen;
import com.finalproyect.medallium.ui.views.SagaScreen;
import com.finalproyect.medallium.ui.views.TribusScreen;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<DetallesYokai> yokaiList = new ArrayList<>();
    private YokaiAdapter yokaiAdapter;
    private static final String BASE_URL = "http://192.168.22.8:8080/";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerViewPopulares;
        yokaiAdapter = new YokaiAdapter(yokaiList);
        recyclerView.setAdapter(yokaiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadYokais(BASE_URL);

        Button tribusButton = root.findViewById(R.id.tribus_button);
        Button elementosButton = root.findViewById(R.id.elementos_button);
        Button rangosButton = root.findViewById(R.id.rangos_button);
        Button sagaButton = root.findViewById(R.id.saga_button);

        tribusButton.setOnClickListener(v -> launchTribus());
        elementosButton.setOnClickListener(v -> launchElementos());
        rangosButton.setOnClickListener(v -> launchRangos());
        sagaButton.setOnClickListener(v -> launchSaga());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void launchRangos() {
        Intent intent = new Intent(getActivity(), RangosScreen.class);
        startActivity(intent);
    }

    public void launchTribus() {
        Intent intent = new Intent(getActivity(), TribusScreen.class);
        startActivity(intent);
    }

    public void launchSaga() {
        Intent intent = new Intent(getActivity(), SagaScreen.class);
        startActivity(intent);
    }

    public void launchElementos() {
        Intent intent = new Intent(getActivity(), ElementosScreen.class);
        startActivity(intent);
    }

    private void loadYokais(String baseUrl) {
        ApiService apiService = RetrofitClient.getClient(baseUrl).create(ApiService.class);
        Call<List<DetallesYokai>> call = apiService.getDetallesYokai();

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<DetallesYokai>> call, Response<List<DetallesYokai>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("HomeFragment", "Yokais recibidos: " + response.body().toString());

                    yokaiList.clear();
                    yokaiList.addAll(response.body());
                    yokaiAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "Error al cargar los Yokais", Toast.LENGTH_SHORT).show();
                    Log.e("HomeFragment", "Error en la respuesta de la API: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<DetallesYokai>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("HomeFragment", "Error en la llamada a la API: " + t.getMessage());
            }
        });
    }
}