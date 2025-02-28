package com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.DescripcionYokai;
import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.EstadisticasYokai;
import com.finalproyect.medallium.ui.views.YokaiView.tabbedViews.fragments.FusionesYokai;

public class ViewPagerAdapter extends FragmentStateAdapter {

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
        switch (position) {
            case 0:
                return new DescripcionYokai();
            case 1:
                return new EstadisticasYokai();
            case 2:
                return new FusionesYokai();
            default:
                return new DescripcionYokai();
        }
    }
}

