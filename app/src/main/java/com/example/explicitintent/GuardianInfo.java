package com.example.explicitintent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuardianInfo extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener{

    EditText etGuardianName;
    EditText etGuardianRelation;
    Button btSubmitGuardianInfo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_guardian_info);

    }

    private void initializeUI(View view){
        this.etGuardianName = view.findViewById(R.id.etGuardianName);
        this.etGuardianRelation = view.findViewById(R.id.etGuardianRelation);
        this.btSubmitGuardianInfo = view.findViewById(R.id.btSubmitGuardianInfo);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_guardian_info, container, false);
        initializeUI(view);

        etGuardianName.setOnEditorActionListener(this);
        etGuardianRelation.setOnEditorActionListener(this);
        btSubmitGuardianInfo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if(view == btSubmitGuardianInfo){
            String guardianName = String.valueOf(etGuardianName.getText());
            String guardianRelation = String.valueOf(etGuardianRelation.getText());
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}