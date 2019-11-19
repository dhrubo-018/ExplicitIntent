package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Activity3 extends AppCompatActivity {

    EditText etSurName;
    Button btnSubmit;
    TextView tvRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurName = findViewById(R.id.etSurName);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvRead = findViewById(R.id.tvRead);

        String fileName = getIntent().getStringExtra("fileName");
        String name = load(fileName);
        System.out.println("upore "+name);
        if(name.equals("fuad")){
            tvRead.setText("yes");
        }else{
            tvRead.setText("no");
        }
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etSurName.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, "please enter your sur name first", Toast.LENGTH_SHORT).show();
                }else{
                    String surName = etSurName.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("surName", surName);
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }
            }
        });
    }

    public String load(String fileName){
        FileInputStream fileInputStream = null;
        String name ="";

        try {
            fileInputStream = openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ((name = bufferedReader.readLine()) != null){
                    stringBuilder.append(name);
            }
            name = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name);
        return name;
    }
}
