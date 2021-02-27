package com.makhalibagas.sculpture.Utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.View.Activity.AboutActivity;
import com.makhalibagas.sculpture.View.Activity.HelpActivity;
import com.makhalibagas.sculpture.View.Activity.LoginActivity;

public class BottomFragmentManager extends BottomSheetDialogFragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView about = view.findViewById(R.id.tv_about);
        TextView help = view.findViewById(R.id.tv_help);
        TextView out = view.findViewById(R.id.tv_out);

        about.setOnClickListener(this);
        help.setOnClickListener(this);
        out.setOnClickListener(this);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_about:
                startActivity(new Intent(getContext(), AboutActivity.class));
                break;
            case R.id.tv_help:
                startActivity(new Intent(getContext(), HelpActivity.class));
                break;
            case R.id.tv_out:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
        }
    }
}
