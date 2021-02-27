package com.makhalibagas.sculpture.View.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.View.Fragment.GalleryFragment;
import com.makhalibagas.sculpture.View.Fragment.HomeFragment;
import com.makhalibagas.sculpture.View.Fragment.ProfileFragment;
import com.makhalibagas.sculpture.View.Fragment.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationViewEx.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_frame, fragment, fragment.getClass().getSimpleName())
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_score:
                    fragment = new ScoreFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_frame, fragment, fragment.getClass().getSimpleName())
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_gallery:
                    fragment = new GalleryFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_frame, fragment, fragment.getClass().getSimpleName())
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_frame, fragment, fragment.getClass().getSimpleName())
                            .addToBackStack(null)
                            .commit();
                    return true;
            }

            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigation);
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        bottomNavigationViewEx.setSelectedItemId(R.id.navigation_home);
    }
}
