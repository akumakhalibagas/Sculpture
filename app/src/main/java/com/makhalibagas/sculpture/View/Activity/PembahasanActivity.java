package com.makhalibagas.sculpture.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.makhalibagas.sculpture.Adapter.PembahasanAdapter;
import com.makhalibagas.sculpture.Adapter.QuestionAdapter;
import com.makhalibagas.sculpture.Model.Question.DataItem;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;
import com.makhalibagas.sculpture.ViewModel.QuizViewModel;

import java.util.List;

public class PembahasanActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembahasan);



        recyclerView = findViewById(R.id.rv_pembahasan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        QuizViewModel quizViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(QuizViewModel.class);
        quizViewModel.setDataList(getApplicationContext());
        quizViewModel.getDataList().observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                PembahasanAdapter pembahasanAdapter = new PembahasanAdapter(getApplicationContext(), dataItems.get(0).getQuestion());
                recyclerView.setAdapter(pembahasanAdapter);
            }
        });
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
