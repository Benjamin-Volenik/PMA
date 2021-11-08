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
        TextInputLayout txtImeProfesora = (TextInputLayout)findViewById(R.id.textInputLayout2);
        TextInputLayout txtBrojAkademskeGodine = (TextInputLayout)findViewById(R.id.textInputLayout3);
        TextInputLayout txtBrojSati = (TextInputLayout)findViewById(R.id.textInputLayout4);
        TextInputLayout txtBrojSatiLv = (TextInputLayout)findViewById(R.id.textInputLayout5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StudentInfoActivity.this,SummaryActivity.class);
                i.putExtra("Predmet",txtPredmet.getEditText().getText().toString());
                i.putExtra("Profesor",txtImeProfesora.getEditText().getText().toString());
                i.putExtra("Godina",txtBrojAkademskeGodine.getEditText().getText().toString());
                i.putExtra("BrojSati",txtBrojSati.getEditText().getText().toString());
                i.putExtra("BrojSatiLv",txtBrojSatiLv.getEditText().getText().toString());
                Bundle extras = getIntent().getExtras();
                if(extras != null)
                {
                    i.putExtra("Ime",extras.getString("Ime"));
                    i.putExtra("Prezime",extras.getString("Prezime"));
                    i.putExtra("Datum",extras.getString("Datum"));
                }
                startActivity(i);
            }
        });

    }
}