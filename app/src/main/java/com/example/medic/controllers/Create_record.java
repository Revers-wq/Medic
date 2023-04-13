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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Create_record extends AppCompatActivity {
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
        tx16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        Profile profile = new Profile(name,lastname,mid,bith,pol, "dsadas");
        apiClient.getApiService(this).createProfil(profile)
                .enqueue(new Callback<List<Profile>>() {
                    @Override
                    public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                        if(response.isSuccessful())
                        {
                            return;
                        }
                        sessionManager.saveRecord(record);
                        Intent intent = new Intent(Create_record.this, Glavnay.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Profile>> call, Throwable t) {
                        return;
                    }
                });
    }
}