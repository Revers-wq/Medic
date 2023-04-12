package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medic.R;
import com.example.medic.data.ApiClient;
import com.example.medic.data.SessionManager;
import com.example.medic.models.SendCodeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_passwd extends AppCompatActivity {
    Button bt;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_passwd);
        bt = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName2);
        bt.setEnabled(false);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code();
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(editText.getText().toString().length()==0)
                {
                    bt.setEnabled(false);
                }
                else
                {
                    bt.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void code()
    {
        SessionManager sessionManager = new SessionManager(this);
        String email = editText.getText().toString();
        sessionManager.saveEmail(email);
        ApiClient apiClient = new ApiClient();
        apiClient.getApiService(this).sendCode(email)
                .enqueue(new Callback<SendCodeResponse>() {
                    @Override
                    public void onResponse(Call<SendCodeResponse> call, Response<SendCodeResponse> response) {
                        if(!response.isSuccessful())
                        {

                            return;
                        }
                        Intent intent = new Intent(Login_passwd.this, Send_Code.class);
                        startActivity(intent);
                        return;
                    }

                    @Override
                    public void onFailure(Call<SendCodeResponse> call, Throwable t) {
                        Toast toast=Toast.makeText(Login_passwd.this, "Ошибка", Toast.LENGTH_LONG);
                        toast.show();;
                    }
                });
    }
}