package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;

public class DetailMateriActivity extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_MATERI = "extra_materi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_materi);
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
