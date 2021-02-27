package com.makhalibagas.sculpture.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhalibagas.sculpture.Model.Materi.Materi;
import com.makhalibagas.sculpture.R;
import com.makhalibagas.sculpture.View.Activity.DetailMateriActivity;

import java.util.List;

public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.MateriViewHolder> {
    private Context context;
    private List<Materi> materiList;

    public MateriAdapter(Context context, List<Materi> materiList) {
        this.context = context;
        this.materiList = materiList;
    }

    @NonNull
    @Override
    public MateriAdapter.MateriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_materi, parent, false);

        return new MateriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateriAdapter.MateriViewHolder holder, int position) {
        Materi materi = materiList.get(position);
        holder.title.setText(materi.getTitle());
    }

    @Override
    public int getItemCount() {
        return materiList.size();
    }

    public class MateriViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        public MateriViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
        }

        @Override
        public void onClick(View v) {
            Materi materi = materiList.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailMateriActivity.class);
            intent.putExtra(DetailMateriActivity.EXTRA_MATERI, materi);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
