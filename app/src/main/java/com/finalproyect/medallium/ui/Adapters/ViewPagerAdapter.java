package com.finalproyect.medallium.ui.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.DescripcionYokai;
import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.EstadisticasYokai;
import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.FusionesYokai;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final SparseArrayCompat<Fragment> registeredFragments = new SparseArrayCompat<>();

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return 3;  // 3 pestañas
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new DescripcionYokai();
                break;
            case 1:
                fragment = new EstadisticasYokai();
                break;
            case 2:
                fragment = new FusionesYokai();
                break;
            default:
                fragment = new DescripcionYokai();
                break;
        }
        Log.d("ViewPagerAdapter", "Fragment creado en posición: " + position);
        registeredFragments.put(position, fragment);
        return fragment;
    }
    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }
}

