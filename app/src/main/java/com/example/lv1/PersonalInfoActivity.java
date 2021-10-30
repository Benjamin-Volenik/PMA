package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputLayout txtIme = (TextInputLayout)findViewById(R.id.txtIme);

        Button button = (Button)findViewById(R.id.btnPosalji);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(PersonalInfoActivity.this,StudentInfoActivity.class);
                i.putExtra("Ime",txtIme.getEditText().getText().toString());
                startActivity(i);
            }
        });
    }


}