package com.makhalibagas.sculpture.View.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.makhalibagas.sculpture.Model.Login.Data;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;
import com.makhalibagas.sculpture.View.Activity.AboutActivity;
import com.makhalibagas.sculpture.View.Activity.HelpActivity;
import com.makhalibagas.sculpture.View.Activity.LoginActivity;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getData(view);
        initOnClick(view);


        super.onViewCreated(view, savedInstanceState);
    }

    private void initOnClick(View view){
        CardView cvAbout = view.findViewById(R.id.cv_about);
        cvAbout.setOnClickListener(this);
        CardView cvHelp = view.findViewById(R.id.cv_help);
        cvHelp.setOnClickListener(this);
        CardView cvOut = view.findViewById(R.id.cv_out);
        cvOut.setOnClickListener(this);
        Button button = view.findViewById(R.id.bt_menu);
        button.setOnClickListener(this);
    }
    private void getData(@NonNull View view) {
        SharedPreferences sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences("myPREF", Context.MODE_PRIVATE);
        Data data = new Data();

        String fullName = data.getFullname();
        String sekolah = data.getSekolah();

        String name = sharedPreferences.getString("NAME", fullName);
        String sekolahku = sharedPreferences.getString("SEKOLAH", sekolah);

        TextView tvSekolah = view.findViewById(R.id.tv_sekolah);
        tvSekolah.setText(sekolahku);

        TextView tvName = view.findViewById(R.id.tv_name);
        tvName.setText(name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_about:
                startActivity(new Intent(getContext(), AboutActivity.class));
                break;
            case R.id.cv_help:
                startActivity(new Intent(getContext(), HelpActivity.class));
                break;
            case R.id.cv_out:
                SharedPreferences sharedPreferences = Objects.requireNonNull(getActivity()).getApplicationContext().getSharedPreferences("myPREF", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("TOKEN");
                editor.apply();
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
            case R.id.bt_menu:
                BottomFragmentManager bottomFragmentManager = new BottomFragmentManager();
                bottomFragmentManager.show(getParentFragmentManager(), "");
                break;
        }
    }
}
