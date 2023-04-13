package com.example.medic.controllers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.medic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Supporting extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporting);
        bottomNavigationView = findViewById(R.id.nav_bot);
        bottomNavigationView.setSelectedItemId(R.id.Support);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Analizi:
                        startActivity(new Intent(Supporting.this, Glavnay.class));
                        return true;
                    case R.id.Result:
                        startActivity(new Intent(Supporting.this, Result.class));
                        return true;
                    case R.id.Support:
                        return true;
                    case R.id.Profilee:
                        startActivity(new Intent(Supporting.this, Profile_check.class));
                        return true;
                }
                return false;
            }
        });
    }
}