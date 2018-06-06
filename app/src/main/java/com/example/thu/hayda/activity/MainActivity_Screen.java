package com.example.thu.hayda.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thu.hayda.R;

public class MainActivity_Screen extends AppCompatActivity {
private static int SPLASH=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity_Screen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH);
    }
}
