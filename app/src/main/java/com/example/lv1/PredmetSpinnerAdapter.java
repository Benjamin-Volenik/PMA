package com.example.lv1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PredmetSpinnerAdapter extends ArrayAdapter<CourseModel> {
    private Context context;
    private ArrayList<CourseModel> courses;

    public PredmetSpinnerAdapter(@NonNull Context context, int textViewResourceId, ArrayList<CourseModel> courses) {
        super(context, textViewResourceId, courses);
        this.context = context;
        this.courses = courses;
    }

    @Override
    public int getCount(){
        return courses.size();
    }

    @Override
    public CourseModel getItem(int position){
        return courses.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) super.getView(position, convertView, parent);
        label.setText(courses.get(position).title);

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setText(courses.get(position).title);

        return label;
    }
}
