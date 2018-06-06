package com.example.thu.hayda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.thu.hayda.R;

public class Exercise_Sum extends AppCompatActivity {
    ImageButton btn_Level1, btn_Level2, btn_Level3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise__sum);

        Addcontrols();

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        btn_Level1.startAnimation(animation);
        btn_Level3.startAnimation(animation);

        Click();
    }

    private void Click() {
        btn_Level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Exercise_Sum.this, ChooseMethodExerciesSum.class);
                intent1.putExtra("ID", "1");
                startActivity(intent1);
            }
        });
        btn_Level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Exercise_Sum.this, ChooseMethodExerciesSum.class);
                intent1.putExtra("ID", "2");
                startActivity(intent1);
            }
        });
        btn_Level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Exercise_Sum.this, ChooseMethodExerciesSum.class);
                intent1.putExtra("ID", "3");
                startActivity(intent1);
            }
        });
    }

    private void Addcontrols() {
        btn_Level1 = findViewById(R.id.btn_Level1);
        btn_Level2 = findViewById(R.id.btn_Level2);
        btn_Level3 = findViewById(R.id.btn_Level3);
    }

}
