package com.example.thu.hayda.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thu.hayda.R;

import java.util.ArrayList;

public class DiglogRecord extends AppCompatActivity {
ImageButton btn_click;
TextView txt_result,txt_Word,txt_Mean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diglog_record);
        //Anh xạ.
      AddControls();
      //nhận dữ liệu intent
      Intent intent=getIntent();
      txt_Word.setText(intent.getStringExtra("Word"));
      txt_Mean.setText(intent.getStringExtra("Mean"));

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpeechInput();
            }
        });

    }

    private void AddControls() {
        btn_click=findViewById(R.id.btn_click);
        txt_result=findViewById(R.id.txt_result);
        txt_Word=findViewById(R.id.txt_Word);
        txt_Mean=findViewById(R.id.txt_Mean);
    }

    public void getSpeechInput() {

        try {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech recognition demo");
            startActivityForResult(intent, 10);
        } catch (ActivityNotFoundException e) {
            String appPackageName = "com.google.android.googlequicksearchbox";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String t = "a";
        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            t = result.get(0);
            txt_result.setText(result.get(0));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
