package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.medic.R;
import com.example.medic.data.SessionManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Objects;

public class Zakaz extends AppCompatActivity {
    String adr;
    SessionManager sessionManager;
    BottomSheetDialog dialog;
    EditText editText;
    EditText ed2;
    Button bt24;
    Spinner sp;
    ImageView im11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz);
        sessionManager =new SessionManager(this);
        editText = findViewById(R.id.editTextTextPersonName12);
        ed2=findViewById(R.id.editTextTextPersonName13);
        bt24=findViewById(R.id.button24);
        sp=findViewById(R.id.spinner);
        im11=findViewById(R.id.imageView11);
        im11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Zakaz.this,Korzina.class));
            }
        });
        String check=sessionManager.getAdress();
        if(Objects.equals(check, ""))
        {
            editText.setText(sessionManager.getAdress());
        }
        dialog= new BottomSheetDialog(this);
        bt24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDialog3();
                dialog.show();
            }
        });
        ed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDialog2();
                dialog.show();
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDialog();
                dialog.show();
            }
        });
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void CreateDialog() {
        View view= getLayoutInflater().inflate(R.layout.adress, null, false);
        Button bt23 = view.findViewById(R.id.button26);
        Switch  sw = view.findViewById(R.id.switch1);
        EditText ed16, ed20;
        ed16=view.findViewById(R.id.editTextTextPersonName16);
        ed20=view.findViewById(R.id.editTextTextPersonName20);
        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adress=ed16.getText().toString()+" "+ed20.getText().toString();
                if(sw.isChecked()==true)
                {
                    sessionManager.saveAdres(adress);
                }
                adr=adress;
                editText.setText(adr);
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
    }
    private void CreateDialog2() {
        View view= getLayoutInflater().inflate(R.layout.date_time, null, false);
        Button bt23 = view.findViewById(R.id.button33);
        ImageView im10 = view.findViewById(R.id.imageView10);
        im10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        bt23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
    }
    private void CreateDialog3() {
        View view= getLayoutInflater().inflate(R.layout.patient, null, false);
        Button bt36 = view.findViewById(R.id.button36);
        Button bt37 = view.findViewById(R.id.button37);
        ImageView im43 = view.findViewById(R.id.imageView4);
        bt37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                sessionManager.savePerexod("1");
                startActivity(new Intent(Zakaz.this,Create_record.class));
            }
        });
        im43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        bt36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
    }
}