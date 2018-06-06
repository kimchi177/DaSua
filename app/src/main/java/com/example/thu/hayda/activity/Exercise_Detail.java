package com.example.thu.hayda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.thu.hayda.R;

import static com.example.thu.hayda.R.anim.alpha;

public class Exercise_Detail extends AppCompatActivity {
    ImageButton IPA_One, IPA_Two, IPA_Three, IPA_Four, IPA_Five, IPA_Six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise__detail);

        Addcontrols();

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        IPA_One.startAnimation(animation);
        IPA_Three.startAnimation(animation);
        IPA_Five.startAnimation(animation);

        Click();

    }

    private void Click() {
        IPA_One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Exercise_Detail.this, ChooseMethodExercies.class);
                intent1.putExtra("ID", "1");
                startActivity(intent1);
            }
        });
        IPA_Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Exercise_Detail.this, ChooseMethodExercies.class);
                intent2.putExtra("ID", "2");
                startActivity(intent2);
            }
        });
        IPA_Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Exercise_Detail.this, ChooseMethodExercies.class);
                intent3.putExtra("ID", "3");
                startActivity(intent3);
            }
        });
        IPA_Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Exercise_Detail.this, ChooseMethodExercies.class);
                intent4.putExtra("ID", "4");
                startActivity(intent4);
            }
        });
        IPA_Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Exercise_Detail.this, ChooseMethodExercies.class);
                intent5.putExtra("ID", "5");
                startActivity(intent5);
            }
        });
        IPA_Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(Exercise_Detail.this, ChooseMethodExercies.class);
                intent6.putExtra("ID", "6");
                startActivity(intent6);
            }
        });
    }

    private void Addcontrols() {
        IPA_One = findViewById(R.id.btn_IPA_One);
        IPA_Two = findViewById(R.id.btn_IPA_Two);
        IPA_Three = findViewById(R.id.btn_IPA_Three);
        IPA_Four = findViewById(R.id.btn_IPA_Four);
        IPA_Five = findViewById(R.id.btn_IPA_Five);
        IPA_Six = findViewById(R.id.btn_IPA_Six);
    }
}
