package com.example.lv1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ProffesorSpinnerAdapter extends ArrayAdapter<Instructor> {

    private Context context;
    private ArrayList<Instructor> instructors;

    public ProffesorSpinnerAdapter(@NonNull Context context, int textViewResourceId, ArrayList<Instructor> instructors) {
        super(context, textViewResourceId, instructors);
        this.context = context;
        this.instructors = instructors;

    }

    @Override
    public int getCount(){
        return instructors.size();
    }

    @Override
    public Instructor getItem(int position){
        return instructors.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) super.getView(position, convertView, parent);

        label.setText(instructors.get(position).name);

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {

        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setText(instructors.get(position).name);

        return textView;
    }
}
