package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;

public class DetailTutorialActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tutorial);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_back:
                onBackPressed();
                finish();
            case R.id.bt_menu:
                BottomFragmentManager bottomFragmentManager = new BottomFragmentManager();
                bottomFragmentManager.show(getSupportFragmentManager(), "");
        }
    }
}
