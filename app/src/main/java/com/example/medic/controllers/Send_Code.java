package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medic.R;
import com.example.medic.data.ApiClient;
import com.example.medic.data.SessionManager;
import com.example.medic.models.SendCodeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Send_Code extends AppCompatActivity {
    EditText edCode1, edCode2,edCode3,edCode4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_code);
        edCode1= findViewById(R.id.editTextPhone3);
        edCode2= findViewById(R.id.editTextPhone2);
        edCode3= findViewById(R.id.editTextPhone);
        edCode4= findViewById(R.id.editTextPhone4);
        edCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edCode2.isSelected();
            }
        });
        edCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edCode3.isSelected();
            }
        });
        edCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edCode4.isSelected();
            }
        });
        edCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                CodeRetrie();
            }
        });
    }
    public void CodeRetrie()
    {
        SessionManager sessionManager = new SessionManager(this);
        String email = sessionManager.getEmail();
        String code = edCode1.getText().toString() + edCode2.getText().toString() + edCode3.getText().toString()+edCode4.getText().toString();
        sessionManager.saveCode(code);
        ApiClient apiClient  = new ApiClient();
        apiClient.getApiService(this).signin(email, code)
                .enqueue(new Callback<SendCodeResponse>() {
                    @Override
                    public void onResponse(Call<SendCodeResponse> call, Response<SendCodeResponse> response) {
                        if(!response.isSuccessful())
                        {

                            return;
                        }
                        sessionManager.saveToken(response.message());
                        Intent intent = new Intent(Send_Code.this, Create_record.class);
                        startActivity(intent);
                        return;
                    }

                    @Override
                    public void onFailure(Call<SendCodeResponse> call, Throwable t) {

                    }
                });
    }
}