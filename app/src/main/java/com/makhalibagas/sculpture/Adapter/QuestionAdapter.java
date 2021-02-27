package com.makhalibagas.sculpture.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makhalibagas.sculpture.Model.Question.QuestionItem;
import com.makhalibagas.sculpture.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuizViewHolder> {

    private Context context;
    private List<QuestionItem> questionItemList;

    public QuestionAdapter(Context context, List<QuestionItem> questionItemList) {
        this.context = context;
        this.questionItemList = questionItemList;
    }

    @NonNull
    @Override
    public QuestionAdapter.QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_question, parent, false);

        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.QuizViewHolder holder, int position) {

        QuestionItem questionItem = questionItemList.get(position);
        holder.tvQuestion.setText(questionItem.getTitle());
        holder.rb1.setText(questionItem.getJsonMember0());
        holder.rb2.setText(questionItem.getJsonMember1());
        holder.rb3.setText(questionItem.getJsonMember2());
        holder.rb4.setText(questionItem.getJsonMember3());


    }

    @Override
    public int getItemCount() {
        return questionItemList.size();
    }

    public static class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion;
        RadioButton rb1,rb2,rb3,rb4;
        public QuizViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            rb1 = itemView.findViewById(R.id.rb1);
            rb2 = itemView.findViewById(R.id.rb2);
            rb3 = itemView.findViewById(R.id.rb3);
            rb4 = itemView.findViewById(R.id.rb4);
        }
    }
}
