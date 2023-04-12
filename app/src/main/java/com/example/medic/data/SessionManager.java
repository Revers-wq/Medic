package com.example.medic.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Objects;

public class SessionManager {
    static SharedPreferences sharedPreferences;
    public SessionManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences("Medic", Context.MODE_PRIVATE);
    }
    public void saveFinishActivity()
    {
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("finish_Activity", "Вы успешно завершили экран приветствия");
        editor.apply();
    }
    public boolean getFinishActivity()
    {
        String finish = sharedPreferences.getString("finish_Activity", null);
        if(Objects.equals(finish, "Вы успешно завершили экран приветствия"))
        {
            return true;
        }
        else
        {return false;}
    }
    public void saveEmail(String email)
    {
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("email", email);
        editor.apply();
    }
    public void saveToken(String token)
    {
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("token", token);
        editor.apply();
    }
    public String getEmail()
    {
        return sharedPreferences.getString("email", null);
    }
    public void saveCode(String code)
    {
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("code", code);
        editor.apply();
    }
    public String getToken()
    {
        return sharedPreferences.getString("token", null);
    }
    public String getCode()
    {
        return sharedPreferences.getString("code", null);
    }


}
