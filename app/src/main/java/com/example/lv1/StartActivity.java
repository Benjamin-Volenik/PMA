package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity implements Serializable {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        Student student = (Student)getIntent().getSerializableExtra("student");

        StudentList studentList = StudentList.getInstance();
        ArrayList<Student> studentiSingleton;
        studentiSingleton = (ArrayList<Student>) studentList.ReturnList();

        List<Object> myDataSet = new ArrayList<>();
        myDataSet.add("Studenti:");
        myDataSet.addAll(studentiSingleton);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerAdapter(myDataSet);
        mRecyclerView.setAdapter(mAdapter);

        Button btnDalje = (Button)findViewById(R.id.btnDalje);

        btnDalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, PersonalInfoActivity.class));
            }
        });
    }
}