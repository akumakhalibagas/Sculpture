package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.makhalibagas.sculpture.Adapter.UjianAdapter;
import com.makhalibagas.sculpture.Model.Ujian.Ujian;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;

import java.util.ArrayList;
import java.util.List;

public class UjianActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ujian);

        List<Ujian> ujians = new ArrayList<>();
        ujians.add(new Ujian("Ujian BAB 1", "25 menit - 15 soal"));
        ujians.add(new Ujian("Ujian BAB 2", "25 menit - 25 soal"));
        ujians.add(new Ujian("Ujian BAB 3", "25 menit - 25 soal"));
        ujians.add(new Ujian("Ujian BAB 4", "25 menit - 25 soal"));
        ujians.add(new Ujian("Ujian BAB 5", "25 menit - 30 soal"));

        RecyclerView recyclerView = findViewById(R.id.rv_ujian);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UjianAdapter ujianAdapter = new UjianAdapter(getApplicationContext(), ujians);
        recyclerView.setAdapter(ujianAdapter);
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
