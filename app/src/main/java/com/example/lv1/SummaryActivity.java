package com.example.lv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Button button = (Button)findViewById(R.id.btnSpremi);
        TextView txtView = (TextView)findViewById(R.id.textView1);
        TextView txtView1 = (TextView)findViewById(R.id.textView2);
        TextView txtView2 = (TextView)findViewById(R.id.textView);
        TextView txtView3 = (TextView)findViewById(R.id.textView3);
        TextView txtView4 = (TextView)findViewById(R.id.textView4);
        TextView txtView5 = (TextView)findViewById(R.id.textView5);
        TextView txtView6 = (TextView)findViewById(R.id.textView6);
        TextView txtView7 = (TextView)findViewById(R.id.textView7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =(new Intent(SummaryActivity.this,StartActivity.class));
                i.setFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            txtView.setText(extras.getString("Ime"));
            txtView1.setText(extras.getString("Prezime"));
            txtView2.setText(extras.getString("Datum"));
            txtView3.setText(extras.getString("Predmet"));
            txtView4.setText(extras.getString("Profesor"));
            txtView5.setText(extras.getString("Godina"));
            txtView6.setText(extras.getString("BrojSati"));
            txtView7.setText(extras.getString("BrojSatiLv"));
        }
    }
}