package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2;
    Button btnAct3;
    TextView tvResults;
    final  int ACTIVITY3 = 3;
    File userInfo;
    private  final String fileName = "userInfo.txt";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY3){
            if(resultCode == RESULT_OK){
                String surName = data.getStringExtra("surName");
                tvResults.setText("your surname is " + surName);
            }
            if(resultCode == RESULT_CANCELED){
                tvResults.setText("No data received!");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);
        //userInfo = new File("F:\\labs\\android Udemy\\ExplicitIntent\\app\\src\\main\\res\\database\\userInfo.txt");

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    String name = etName.getText().toString().trim();
                    int extra = 123;

//
//                    try {
//                        addUser(name);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    writes(name);

                    Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity2.class);
                    intent.putExtra("userName", name);
                    intent.putExtra("extra", extra);
                    startActivity(intent);
                }
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity3.class);
                    intent.putExtra("fileName", fileName);
                    startActivityForResult(intent, ACTIVITY3);
                }
                
            }
        });
    }

    void addUser(String name)throws IOException{


        try {
            FileWriter fileWriter = new FileWriter(userInfo, true);
            fileWriter.write(System.lineSeparator());
            fileWriter.write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writes(String name){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());

            Toast.makeText(this,    "saved "+name +" to " + getFilesDir() +"/" +fileName, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
