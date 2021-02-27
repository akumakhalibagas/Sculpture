package com.makhalibagas.sculpture.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhalibagas.sculpture.Model.Ujian.Ujian;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.View.Activity.DetailMateriActivity;
import com.makhalibagas.sculpture.View.Activity.QuestionActivity;

import java.util.List;


public class UjianAdapter extends RecyclerView.Adapter<UjianAdapter.MateriViewHolder> {
    private Context context;
    private List<Ujian> ujianList;

    public UjianAdapter(Context context, List<Ujian> ujianList) {
        this.context = context;
        this.ujianList = ujianList;
    }

    @NonNull
    @Override
    public UjianAdapter.MateriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);

        return new MateriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UjianAdapter.MateriViewHolder holder, int position) {
        Ujian ujian = ujianList.get(position);
        holder.title.setText(ujian.getTitle());
        holder.time.setText(ujian.getTime());
    }

    @Override
    public int getItemCount() {
        return ujianList.size();
    }

    public class MateriViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, time;
        public MateriViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            time = itemView.findViewById(R.id.tv_time);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Ujian ujian = ujianList.get(getAdapterPosition());
            Intent intent = new Intent(context, QuestionActivity.class);
            intent.putExtra(DetailMateriActivity.EXTRA_MATERI, ujian);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
