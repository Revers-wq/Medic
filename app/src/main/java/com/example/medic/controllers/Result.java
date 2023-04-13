package com.example.medic.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Result extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        bottomNavigationView = findViewById(R.id.nav_bot);
        bottomNavigationView.setSelectedItemId(R.id.Result);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Analizi:
                        startActivity(new Intent(Result.this, Glavnay.class));
                        return true;
                    case R.id.Result:
                        return true;
                    case R.id.Support:
                        startActivity(new Intent(Result.this, Supporting.class));
                        return true;
                    case R.id.Profilee:
                        startActivity(new Intent(Result.this, Profile_check.class));
                        return true;
                }
                return false;
            }
        });
    }
}