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
        TextView txtView2 = (TextView)findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =(new Intent(SummaryActivity.this,PersonalInfoActivity.class));
                i.setFlags(getIntent().FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            txtView.setText(extras.getString("Ime"));
            txtView2.setText(extras.getString("Predmet"));
        }
    }
}