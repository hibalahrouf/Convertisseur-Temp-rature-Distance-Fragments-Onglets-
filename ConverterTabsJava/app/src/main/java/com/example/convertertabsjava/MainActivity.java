package com.example.convertertabsjava;

import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private static final String[] TAB_TITLES = {"Temperature", "Distance"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs   = findViewById(R.id.tabs);
        ViewPager2 pager = findViewById(R.id.pager);

        TabsPagerAdapter pagerAdapter = new TabsPagerAdapter(this);
        pager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabs, pager,
                (tab, position) -> tab.setText(TAB_TITLES[position])
        ).attach();

        // Modern back press handling (replaces deprecated onBackPressed)
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        });
    }

    private void showExitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to quit?")
                .setPositiveButton("Yes, Quit", (dialog, which) -> finish())
                .setNegativeButton("Cancel", null)
                .show();
    }
}