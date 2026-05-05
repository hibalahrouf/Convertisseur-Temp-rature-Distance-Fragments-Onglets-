package com.example.convertertabsjava;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsPagerAdapter extends FragmentStateAdapter {

    private static final int TOTAL_TABS = 2;

    public TabsPagerAdapter(@NonNull FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:  return new TemperatureFragment();
            case 1:  return new DistanceFragment();
            default: return new TemperatureFragment();
        }
    }

    @Override
    public int getItemCount() {
        return TOTAL_TABS;
    }
}
