package com.example.medic;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    static SharedPreferences sharedPreferences;
    public SessionManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences("Medic", Context.MODE_PRIVATE);
    }
    static public boolean saveFinishActivity(int size)
    {
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString("finish_Activity", "Вы успешно завершили экран приветствия");
        editor.apply();
        return true;
    }

}
