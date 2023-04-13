package com.example.medic.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medic.R;
import com.example.medic.data.SessionManager;
import com.example.medic.Logic.SwitchScreen;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;
    int x;
    SwitchScreen switchScreen =new SwitchScreen();
    int y;

    TextView mainText, text, skip;
    ImageView swipeImage, staticImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SessionManager sessionManager1 = new SessionManager(this);
        String token = sessionManager1.getToken();
        if(token!=null)
        {
            //startActivity(new Intent(MainActivity.this, Create_record.class));
        }
        skip  = findViewById(R.id.textView);
        mainText= findViewById(R.id.textView2);
        text= findViewById(R.id.textView3);
        swipeImage = findViewById(R.id.imageView2);
        staticImage  =findViewById(R.id.imageView);
        sessionManager = new SessionManager(this);
        switchScreen.FillQueae();
        setObject(switchScreen.getQueae());
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip.setText(switchScreen.getTextViewString(switchScreen.viewPagerItemArrayList.size()));
                if(switchScreen.viewPagerItemArrayList.size()==0)
                {
                    sessionManager.saveFinishActivity();
                    Intent intent = new Intent(MainActivity.this, Login_passwd.class);
                    startActivity(intent);
                    return;
                }
                setObject(switchScreen.getQueae());
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            x= (int) event.getX();
            y = (int) event.getY();
        }
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            if(switchScreen.viewPagerItemArrayList.size()==0)
            {
                return super.onTouchEvent(event);
            }
            if (event.getX() < x) {
                skip.setText(switchScreen.getTextViewString(switchScreen.viewPagerItemArrayList.size()));
                setObject(switchScreen.getQueae());

            }
        }
        return super.onTouchEvent(event);
    }

    public void setObject(String[] list)
    {
        mainText.setText(list[0]);
        text.setText(list[1]);
        swipeImage.setImageResource(Integer.parseInt(list[2]));
        staticImage.setImageResource(R.drawable.staticimage);
    }
}