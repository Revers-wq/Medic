package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.medic.R;

public class Korzina extends AppCompatActivity {
    ImageView im8, im9;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korzina);
        im8=findViewById(R.id.imageView8);
        im9=findViewById(R.id.imageView9);
        bt=findViewById(R.id.button21);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Korzina.this, Zakaz.class);
                startActivity(intent);
            }
        });
        im8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Korzina.this, Glavnay.class));
            }
        });
    }
}