package com.example.medic.data.Service;

import com.example.medic.models.Profile;
import com.example.medic.models.SendCodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("sendCode")
    Call<SendCodeResponse> sendCode(@Header("email") String email);
    @POST("signin")
    Call<SendCodeResponse> signin(@Header("email") String email , @Header("code") String code);
    @POST("createProfile")
    Call<List<Profile>> createProfile(@Body Profile profile);
}
