package com.example.thu.hayda.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.thu.hayda.R;
//import com.example.thu.hayda.AdapterWord;
import com.example.thu.hayda.Database;
import com.example.thu.hayda.DictionaryModel;


import java.util.ArrayList;
import java.util.Locale;

public class MainActivity_LearnSpeak extends AppCompatActivity {
    final String DATABASE_NAME = "thth.sqlite";
    SQLiteDatabase database;

    ImageView img_speak, img_image,btnvideo;
    ListView recyclerView;
    ArrayList<DictionaryModel> list;
    AdapterWord adapter;
    TextToSpeech textToSpeech;
    String _value="";
    MediaPlayer mediaPlayer;
    String stream = "http://mic.duytan.edu.vn:86/ncs.mp3";
    String Link_video = "http://mic.duytan.edu.vn:86/ncs.mp3";
    Boolean prepare = false;
    Boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__learn_speak);
        //aasnh xạ
        AddCOntrols();

        //lấy dữ liệu intent
        Intent t = getIntent();
         _value = getIntent().getStringExtra("id_Ipa");
        database = Database.initDatabase(this, DATABASE_NAME);

        //lấy dữ liệu IPA từ database.
        Cursor cursor = database.rawQuery("SELECT image,link_Audio,link_Video FROM Ipa where id_Ipa=? ", new String[]{_value});
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            byte[] anh = cursor.getBlob(0);
            stream = (cursor.getString(1));
            Link_video = (cursor.getString(2));
            Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(anh, 0, anh.length);
            img_image.setImageBitmap(bmHinhDaiDien);
        }

        //speak :loa phát âm IPA
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        new PlayerTask().execute(stream);
        mediaPlayer.start();
        img_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    started = true;
                    mediaPlayer.start();
            }
        });

        // dọc table  word ứng với mỗi âm từ database về.
        readData1();

        //click video.
        ClickVideo();
    }

    private void ClickVideo() {
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(MainActivity_LearnSpeak.this,Main_YoutubeAPI.class);
                t.putExtra("Link_video", Link_video);
                startActivity(t);
            }
        });
    }

    class PlayerTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.prepare();
                prepare = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prepare;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mediaPlayer.start();
            img_speak.setEnabled(true);
        }
    }
    private void AddCOntrols() {
        img_speak = (ImageView) findViewById(R.id.img_speak);
        img_image = (ImageView) findViewById(R.id.img_image);
        btnvideo = (ImageView) findViewById(R.id.btnvideo);
        recyclerView = (ListView) findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new AdapterWord(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void readData1() {
       try {
           database = Database.initDatabase(this, DATABASE_NAME);
           Cursor cursor = database.rawQuery("SELECT * FROM word  where id_ipa=? ", new String[]{_value});
           list.clear();
           for (int i = 0; i < cursor.getCount(); i++) {
               cursor.moveToPosition(i);
               String word = cursor.getString(2);
               String ipa = cursor.getString(3);
               String mean = cursor.getString(4);
               list.add(new DictionaryModel(ipa, word, mean));


           }
           adapter.notifyDataSetChanged();
       }
       catch (Exception e)
       {e.printStackTrace();}
    }
}

