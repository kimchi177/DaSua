package com.example.thu.hayda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.thu.hayda.R;

public class ChooseMethodExerciesSum extends AppCompatActivity {
    ImageButton btn_exerciesListenSum, btn_exerciesReadSum;
    String Result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_method_exercies_sum);
        btn_exerciesListenSum = findViewById(R.id.btn_exerciesListenSum);
        btn_exerciesReadSum = findViewById(R.id.btn_exerciesReadSum);

        Intent intent = getIntent();
        Result = intent.getStringExtra("ID");

        btn_exerciesListenSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Integer.valueOf(Result)==1||Integer.valueOf(Result)==2)
               {
                   Intent intent_1 = new Intent(ChooseMethodExerciesSum.this, ListExcercisListenSum.class);
                   intent_1.putExtra("ID", Result);
                   startActivity(intent_1);
               }
               else
               {
                   Intent intent_2 = new Intent(ChooseMethodExerciesSum.this, ListExercisListenLevelTop.class);
                   intent_2.putExtra("ID", Result);
                   startActivity(intent_2);
               }
            }
        });
        btn_exerciesReadSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_1 = new Intent(ChooseMethodExerciesSum.this, ListExerciesReadSum.class);
                intent_1.putExtra("ID", Result);
                startActivity(intent_1);
            }
        });
    }
}
