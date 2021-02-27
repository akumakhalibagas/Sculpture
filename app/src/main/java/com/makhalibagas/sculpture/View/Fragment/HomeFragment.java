package com.makhalibagas.sculpture.View.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.View.Activity.MateriActivity;
import com.makhalibagas.sculpture.View.Activity.QuizActivity;
import com.makhalibagas.sculpture.View.Activity.TutorialActivity;
import com.makhalibagas.sculpture.View.Activity.UjianActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Button bt_materi = view.findViewById(R.id.bt_materi);
        Button bt_tutorial = view.findViewById(R.id.bt_tutorial);
        Button bt_ujian = view.findViewById(R.id.bt_ujian);
        Button bt_quiz = view.findViewById(R.id.bt_quiz);
        bt_materi.setOnClickListener(this);
        bt_tutorial.setOnClickListener(this);
        bt_ujian.setOnClickListener(this);
        bt_quiz.setOnClickListener(this);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_materi:
                startActivity(new Intent(getContext(), MateriActivity.class));
                break;
            case R.id.bt_tutorial:
                startActivity(new Intent(getContext(), TutorialActivity.class));
                break;
            case R.id.bt_ujian:
                startActivity(new Intent(getContext(), UjianActivity.class));
                break;
            case R.id.bt_quiz:
                startActivity(new Intent(getContext(), QuizActivity.class));
                break;
        }
    }
}
