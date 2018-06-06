package com.example.thu.hayda.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.thu.hayda.Class_ExerciesListen;
import com.example.thu.hayda.Database;
import com.example.thu.hayda.R;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class AdapterExcerciesListenSum extends BaseAdapter {
    Activity context;
    ArrayList<Class_ExerciesListen> list;
    TextToSpeech textToSpeech;


    public AdapterExcerciesListenSum(Activity context, ArrayList<Class_ExerciesListen> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_exercieslistensum, null);


        final TextView txt_RadioOne = row.findViewById(R.id.txt_RadioOneSum);
        final TextView txt_RadioTwo = row.findViewById(R.id.txt_RadioTwoSum);
        ImageButton img_Volum = row.findViewById(R.id.img_VolumSum);
        final RadioButton RdbOne = row.findViewById(R.id.RdbOneSum);
        final RadioButton RdbTwo = row.findViewById(R.id.RdbTwoSum);
        RadioGroup Radio_RG = row.findViewById(R.id.Radio_RGSum);


        final Class_ExerciesListen class_exerciesListen = list.get(position);
        txt_RadioOne.setText(class_exerciesListen.getAnswer_True());
        txt_RadioTwo.setText(class_exerciesListen.getAnswer_false());
        Random r = new Random();
        final int resultRandom = (r.nextInt(4) + 1);  // max: 13, min 0. (max-min+1)+min
        img_Volum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            int result = textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setPitch(0.6f);
                            textToSpeech.setSpeechRate(1.0f);
                            //2
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                textToSpeech.speak(txt_RadioOne.getText().toString(), textToSpeech.QUEUE_FLUSH, null, null);
                                if (resultRandom == 1 || resultRandom == 2) {
                                    textToSpeech.speak(txt_RadioOne.getText().toString(), textToSpeech.QUEUE_FLUSH, null, null);
                                } else
                                    textToSpeech.speak(txt_RadioTwo.getText().toString(), textToSpeech.QUEUE_FLUSH, null, null);

                            } else
                                textToSpeech.speak(txt_RadioOne.getText().toString(), textToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        try {
            if (class_exerciesListen.getStatus().equals("1")) {
                RdbOne.setChecked(true);
                if(class_exerciesListen.getResult().equals("right"))
                {

                    txt_RadioOne.setTextColor(Color.GREEN);
                }
                else
                    txt_RadioOne.setTextColor(Color.RED);
            }
            else
            {
                if (class_exerciesListen.getStatus().equals("2")) {
                    RdbTwo.setChecked(true);
                    if(class_exerciesListen.getResult().equals("right"))
                    {

                        txt_RadioTwo.setTextColor(Color.GREEN);
                    }
                    else
                        txt_RadioTwo.setTextColor(Color.RED);
                }
                else
                {

                        RdbOne.setChecked(false);
                        RdbTwo.setChecked(false);
                        txt_RadioOne.setTextColor(Color.BLACK);
                        txt_RadioTwo.setTextColor(Color.BLACK);

                }
            }
        } catch (Exception e) {
        }
        //event click Groupradio.
        Radio_RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                MediaPlayer songWin = MediaPlayer.create(context, R.raw.win);
                MediaPlayer songFail = MediaPlayer.create(context, R.raw.lose);
                switch (checkedId) {
                    case R.id.RdbOneSum:
                        if (resultRandom == 1 || resultRandom == 2) {
                            Update(class_exerciesListen.getID(), "1", "right");
                            songWin.start();
                        } else {
                            Update(class_exerciesListen.getID(), "1", "wrong");
                            songFail.start();
                        }
                        break;
                    case R.id.RdbTwoSum:
                        if (resultRandom == 3 || resultRandom == 4) {
                            Update(class_exerciesListen.getID(), "2", "right");
                            songWin.start();
                        } else {
                            Update(class_exerciesListen.getID(), "2", "wrong");
                            songFail.start();
                        }
                        break;
                }
            }
        });
        return row;
    }

    public void Update(String id, String Status, String Result) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Status", Status);
        contentValues.put("Result", Result);

        SQLiteDatabase database = Database.initDatabase(context, "thth.sqlite");
        database.update("ExcerciseSumListen", contentValues, "ID = ?", new String[]{id + ""});
    }
}
