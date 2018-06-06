package com.example.thu.hayda.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.thu.hayda.Class_ExerciesListen;
import com.example.thu.hayda.Class_ExerciesRead;
import com.example.thu.hayda.Database;
import com.example.thu.hayda.R;
import com.example.thu.hayda.adapter.AdapterExcerciesListen;
import com.example.thu.hayda.adapter.AdapterExerciesRead;

import java.util.ArrayList;

public class ListExcercisListen extends AppCompatActivity {
    final String DATABASE_NAME = "thth.sqlite";
    SQLiteDatabase database;
    ListView list_ExerciesListen;

    ArrayList<Class_ExerciesListen> list;
    AdapterExcerciesListen adapter;
    Button btn_Reload, btn_Update;
    String Result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_excercis_listen);

        list_ExerciesListen = findViewById(R.id.list_ExerciesListen);
        btn_Reload = findViewById(R.id.btn_Reload);
        btn_Update = findViewById(R.id.btn_Update);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Nabila.ttf");
        btn_Reload.setTypeface(typeface);
        btn_Update.setTypeface(typeface);

        Intent intent = getIntent();
        Result = intent.getStringExtra("ID");

        list = new ArrayList<>();
        adapter = new AdapterExcerciesListen(ListExcercisListen.this, list);
        list_ExerciesListen.setAdapter(adapter);

        database = Database.initDatabase(this, DATABASE_NAME);
//        Cursor cursor = database.rawQuery("SELECT * FROM word  where id_ipa=? ", new String[]{Result});
        Cursor cursor = database.rawQuery("SELECT * FROM Exercise_Listen  where ID_SumIPA=? ", new String[]{Result});
//        Cursor cursor = database.rawQuery("SELECT * FROM Exercise_Listen  where ID_SumIPA=? ", new String[]{Result});
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String word_True = cursor.getString(2);
            String word_False = cursor.getString(3);
            String Status = cursor.getString(4);
            String ID_Exercise_Listen = cursor.getString(1);
            String _Result = cursor.getString(5);
            list.add(new Class_ExerciesListen(word_True, word_False, Status, ID_Exercise_Listen, _Result));

        }
        adapter.notifyDataSetChanged();


        ClickRefresh();
    }

    private void ClickRefresh() {
        btn_Reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("Status", "null");
                contentValues.put("SelectResult", "null");

                SQLiteDatabase database = Database.initDatabase(ListExcercisListen.this, "thth.sqlite");
                database.update("Exercise_Listen", contentValues, "ID_SumIPA = ?", new String[]{Result});
                adapter.notifyDataSetChanged();
            }
        });
    }
}
