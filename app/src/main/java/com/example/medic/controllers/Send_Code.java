package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.medic.R;
import com.example.medic.data.ApiClient;
import com.example.medic.data.SessionManager;
import com.example.medic.models.SendCodeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class code_create extends AppCompatActivity {
    EditText edCode1, edCode2,edCode3,edCode4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_code);
        edCode1= findViewById(R.id.editTextPhone3);
        edCode2= findViewById(R.id.editTextPhone2);
        edCode3= findViewById(R.id.editTextPhone);
        edCode4= findViewById(R.id.editTextPhone4);

    }
    public void CodeRetrie()
    {
        SessionManager sessionManager = new SessionManager(this);
        ApiClient apiClient  = new ApiClient();
        apiClient.getApiService(this).sendCode(sessionManager.getEmail())
                .enqueue(new Callback<SendCodeResponse>() {
                    @Override
                    public void onResponse(Call<SendCodeResponse> call, Response<SendCodeResponse> response) {
                        if(!response.isSuccessful())
                        {
                            return;
                        }
                    }

                    @Override
                    public void onFailure(Call<SendCodeResponse> call, Throwable t) {

                    }
                });
    }
}