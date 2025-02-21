package com.finalproyect.medallium.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.finalproyect.medallium.ElementosScreen;
import com.finalproyect.medallium.Profile;
import com.finalproyect.medallium.R;
import com.finalproyect.medallium.RangosScreen;
import com.finalproyect.medallium.SagaScreen;
import com.finalproyect.medallium.TribusScreen;
import com.finalproyect.medallium.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        CardView cardViewLogo = root.findViewById(R.id.cardViewLogo);
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

    public void launchProfile() {
        Intent intent = new Intent(getActivity(), Profile.class);
        startActivity(intent);
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
}