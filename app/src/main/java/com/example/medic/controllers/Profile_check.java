package com.example.medic.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.medic.R;
import com.example.medic.data.ApiClient;
import com.example.medic.data.SessionManager;
import com.example.medic.models.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile_check extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    EditText ed1, ed2, ed3, ed4, ed5;
    Button bt15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_check);
        bottomNavigationView = findViewById(R.id.nav_bot);
        bottomNavigationView.setSelectedItemId(R.id.Profilee);
        ed1 = findViewById(R.id.editTextTextPersonName7);
        ed2 = findViewById(R.id.editTextTextPersonName10);
        ed3 = findViewById(R.id.editTextTextPersonName9);
        ed4 = findViewById(R.id.editTextDate2);
        ed5 = findViewById(R.id.editTextTextPersonName8);
        bt15=findViewById(R.id.button15);
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateRecord();
            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Analizi:
                        startActivity(new Intent(Profile_check.this, Glavnay.class));
                        return true;
                    case R.id.Result:
                        startActivity(new Intent(Profile_check.this, Result.class));
                        return true;
                    case R.id.Support:
                        startActivity(new Intent(Profile_check.this, Supporting.class));
                        return true;
                    case R.id.Profilee:
                        return true;
                }
                return false;
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
        apiClient.getApiService(this).createProfilee(profile)
                .enqueue(new Callback<List<Profile>>() {
                    @Override
                    public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                        if(response.isSuccessful())
                        {
                            return;
                        }
                        sessionManager.saveRecord(record);
                        Intent intent = new Intent(Profile_check.this, Glavnay.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Profile>> call, Throwable t) {
                        return;
                    }
                });
    }
}