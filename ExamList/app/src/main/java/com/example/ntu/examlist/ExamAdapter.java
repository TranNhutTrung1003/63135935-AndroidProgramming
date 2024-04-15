package com.example.ntu.examlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ItemExamHolder> {

    Context context;
    ArrayList<Exam> lsData;

    public ExamAdapter(Context context, ArrayList<Exam> lsData) {
        this.context = context;
        this.lsData = lsData;
    }

    @NonNull
    @Override
    public ItemExamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exam_item, parent, false);
        ItemExamHolder itemExamHolder = new ItemExamHolder(view);
        return itemExamHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemExamHolder holder, int position) {
        Exam item = lsData.get(position);

        String exContent = item.getExamContent();
        String exDay = item.getExamDay();
        String exName = item.getExamName();

        holder.tvContext.setText(exContent);
        holder.tvDay.setText(exDay);
        holder.tvName.setText(exName);
    }

    @Override
    public int getItemCount() {
        return lsData.size();
    }

    class ItemExamHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvContext, tvDay, tvName;

        public ItemExamHolder(@NonNull View itemView) {
            super(itemView);
            tvContext = itemView.findViewById(R.id.examMessage);
            tvDay = itemView.findViewById(R.id.examDate);
            tvName = itemView.findViewById(R.id.examName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int PositionClicked = getAdapterPosition();
            String name = lsData.get(PositionClicked).getExamName();
            Toast.makeText(v.getContext(), "Bạn đã nhấn vào " + name, Toast.LENGTH_SHORT).show();
        }
    }
}
