package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.medic.R;
import com.example.medic.data.ApiClient;
import com.example.medic.data.SessionManager;
import com.example.medic.models.Profile;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Create_record extends AppCompatActivity {
    Zakaz zakaz =new Zakaz();
    EditText ed1, ed2, ed3, ed4, ed5;
    Button bt;
    TextView tx16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_record);
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName4);
        ed3 = findViewById(R.id.editTextTextPersonName5);
        ed4 = findViewById(R.id.editTextDate);
        ed5 = findViewById(R.id.editTextTextPersonName3);
        bt=findViewById(R.id.button20);
        tx16=findViewById(R.id.textView16);
        SessionManager sessionManager = new SessionManager(this);
        String perexod =" ";
        perexod=sessionManager.getPerexod();
        if(Objects.equals(perexod, "1"))
        {
            tx16.setText("Выход");
        }
        String asd="";
        asd+=perexod;
        String finalAsd = asd;
        tx16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalAsd.equals("1"))
                {
                    sessionManager.savePerexod("0");
                    startActivity(new Intent(Create_record.this, Zakaz.class));
                    return;
                }
                startActivity(new Intent(Create_record.this, Glavnay.class));
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateRecord();
            }
        });
    }
    public void CreateRecord()
    {
        ApiClient apiClient = new ApiClient();
        String record=ed1.getText().toString()+" "+ ed2.getText().toString()+" "+ ed3.getText().toString()+" "+ ed4.getText().toString()+" "+ ed5.getText().toString();
        SessionManager sessionManager =new SessionManager(this);
        String name = ed1.getText().toString();
        String lastname = ed2.getText().toString();
        String mid =ed3.getText().toString();
        String bith = ed4.getText().toString();
        String pol = ed5.getText().toString();
        sessionManager.saveLastName(mid) ;

    }
}