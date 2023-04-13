package com.example.medic.data;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class Authenticator implements Interceptor {
    SessionManager sessionManager;
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        //builder.addHeader("Authorization", "Bearer ");
        return chain.proceed(builder.build());
    }
}
