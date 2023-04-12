package com.example.medic;

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


}
