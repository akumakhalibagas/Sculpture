package com.makhalibagas.sculpture.View.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.Utils.BottomFragmentManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.bt_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomFragmentManager bottomFragmentManager = new BottomFragmentManager();
                bottomFragmentManager.show(getParentFragmentManager(), "");
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
