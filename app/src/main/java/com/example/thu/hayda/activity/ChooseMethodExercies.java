package com.example.thu.hayda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.thu.hayda.R;

public class ChooseMethodExercies extends AppCompatActivity {
    ImageButton btn_exerciesListen, btn_exerciesRead;
    String Result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_method_exercies);

        btn_exerciesListen = findViewById(R.id.btn_exerciesListen);
        btn_exerciesRead = findViewById(R.id.btn_exerciesRead);

        Intent intent = getIntent();
        Result = intent.getStringExtra("ID");

        btn_exerciesListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent(ChooseMethodExercies.this, ListExcercisListen.class);
                intent_1.putExtra("ID", Result);
                startActivity(intent_1);
            }
        });
        btn_exerciesRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent(ChooseMethodExercies.this, ListExerciesRead.class);
                intent_1.putExtra("ID", Result);
                startActivity(intent_1);
            }
        });
    }
}
