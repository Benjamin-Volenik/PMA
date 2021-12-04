package com.example.lv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Object> dataList;
    public MyRecyclerAdapter(List<Object> myDataset) {
        dataList = myDataset;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == 0)
        {
            View view = (View) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.header_view, viewGroup, false);
            return new HeaderViewHolder(view);
        }
        else
        {
            View view = (View) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.student_view, viewGroup, false);
            return new StudentViewHolder(view);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if(dataList.get(position) instanceof String) {
            HeaderViewHolder headViewHolder = (HeaderViewHolder) viewHolder;
            headViewHolder.tvHolderNaslov.setText("Studenti:");
        }
        else if(dataList.get(position) instanceof Student) {
            StudentViewHolder studViewHolder = (StudentViewHolder) viewHolder;
            studViewHolder.tvHolderIme.setText(((Student) dataList.get(position)).VratiImePrezime());
            studViewHolder.tvHolderPredmet.setText(((Student) dataList.get(position)).Predmet.title);
        }
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tvHolderNaslov;
        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHolderNaslov = itemView.findViewById(R.id.tvHolderNaslov);
        }
    }
    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvHolderIme;
        TextView tvHolderPredmet;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHolderIme = itemView.findViewById(R.id.tvHolderIme);
            tvHolderPredmet = itemView.findViewById(R.id.tvHolderPredmet);
        }
    }
}
