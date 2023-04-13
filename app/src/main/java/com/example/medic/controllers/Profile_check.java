package com.example.medic.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile_check extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_check);
        bottomNavigationView = findViewById(R.id.nav_bot);
        bottomNavigationView.setSelectedItemId(R.id.Profilee);
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
}