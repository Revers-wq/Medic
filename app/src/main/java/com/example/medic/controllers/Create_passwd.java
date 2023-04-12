package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.medic.R;

public class Create_passwd extends AppCompatActivity {
    String code="";
    TextView textView;
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_passwd);

        button1.findViewById(R.id.button10);
        button2.findViewById(R.id.button12);
        button3.findViewById(R.id.button11);
        button4.findViewById(R.id.button5);
        button5.findViewById(R.id.button4);
        button6.findViewById(R.id.button3);
        button7.findViewById(R.id.button7);
        button8.findViewById(R.id.button9);
        button9.findViewById(R.id.button8);
        button0.findViewById(R.id.button13);
        textView.findViewById(R.id.textView10);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Create_passwd.this, Create_record.class);
                startActivity(intent);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=0;
                lenght();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=1;
                lenght();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=2;
                lenght();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=3;
                lenght();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=4;
                lenght();

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=5;
                lenght();

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=6;
                lenght();

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=7;
                lenght();

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code+=8;
                lenght();

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                code+=9;
                lenght();
            }
        });
    }
    public void lenght()
    {
        if(code.length()==4)
        {
            Intent intent = new Intent(Create_passwd.this, Create_record.class);
            startActivity(intent);
        }
    }
}