package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvWelcome = findViewById(R.id.tvWelcome);

        String name = getIntent().getStringExtra("userName");
        int extra = getIntent().getIntExtra("extra", 0);
        //String extra = getIntent().getStringExtra("extra");
        System.out.println(extra);
        tvWelcome.setText(extra + "," + name + ", welcome to Activity 2!");
    }
}
