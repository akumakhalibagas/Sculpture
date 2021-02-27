package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.makhalibagas.sculpture.Adapter.QuestionAdapter;
import com.makhalibagas.sculpture.Model.Question.DataItem;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;
import com.makhalibagas.sculpture.ViewModel.QuizViewModel;

import java.util.List;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_question);


        recyclerView = findViewById(R.id.rv_question);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        QuizViewModel quizViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(QuizViewModel.class);
        quizViewModel.setDataList(getApplicationContext());
        quizViewModel.getDataList().observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                QuestionAdapter questionAdapter = new QuestionAdapter(getApplicationContext(), dataItems.get(0).getQuestion());
                recyclerView.setAdapter(questionAdapter);
            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_back:
                onBackPressed();
            case R.id.bt_menu:
                BottomFragmentManager bottomFragmentManager = new BottomFragmentManager();
                bottomFragmentManager.show(getSupportFragmentManager(), "");

            case R.id.bt_selesai:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialog_bingung);
                Button btKembali = dialog.findViewById(R.id.bt_back);
                btKembali.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                Button btSelesai = dialog.findViewById(R.id.bt_selesai);
                btSelesai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Dialog dialogHore = new Dialog(getApplicationContext());
                        dialog.setContentView(R.layout.dialog_hore);
                        Button ulangi = dialog.findViewById(R.id.bt_ulangi);
                        Button hasil = dialog.findViewById(R.id.bt_hasil);
                        ulangi.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialogHore.dismiss();
                            }
                        });

                        hasil.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getApplicationContext(), HasilActivity.class));
                            }
                        });
                        dialog.show();
                    }
                });
                dialog.show();


        }
    }
}
