package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Button button = (Button)findViewById(R.id.BtnPosalji2);
        TextInputLayout txtPredmet = (TextInputLayout)findViewById(R.id.textInputLayout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentInfoActivity.this,SummaryActivity.class);
                i.putExtra("Predmet",txtPredmet.getEditText().getText().toString());
                Bundle extras = getIntent().getExtras();
                if(extras != null)
                {
                    i.putExtra("Ime",extras.getString("Ime"));
                }
                startActivity(i);
            }
        });

    }
}