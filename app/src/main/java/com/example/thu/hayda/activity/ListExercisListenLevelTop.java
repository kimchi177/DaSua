package com.example.thu.hayda.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.thu.hayda.Class_ExerciesListen;
import com.example.thu.hayda.Database;
import com.example.thu.hayda.R;
import com.example.thu.hayda.adapter.AdapterExcerciesListen;
import com.example.thu.hayda.adapter.AdapterExcerisListenSumTop;

import java.util.ArrayList;

public class ListExercisListenLevelTop extends AppCompatActivity {
    final String DATABASE_NAME = "thth.sqlite";
    SQLiteDatabase database;
    ListView list_ExerciesListenSumTop;

    ArrayList<Class_ExerciesListen> list;
    AdapterExcerisListenSumTop  adapter;
    Button btn_Reload_SUMTOP,btn_btn_Reload_SUMTOPUpdate;
    String Result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercis_listen_level_top);

        list_ExerciesListenSumTop=findViewById(R.id.list_ExerciesListenSumTop);
        btn_Reload_SUMTOP=findViewById(R.id.btn_Reload_SUMTOP);
        btn_btn_Reload_SUMTOPUpdate=findViewById(R.id.btn_btn_Reload_SUMTOPUpdate);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Nabila.ttf");
        btn_Reload_SUMTOP.setTypeface(typeface);
        btn_btn_Reload_SUMTOPUpdate.setTypeface(typeface);
        Intent intent = getIntent();
        Result = intent.getStringExtra("ID");

        list = new ArrayList<>();
        adapter = new AdapterExcerisListenSumTop(ListExercisListenLevelTop.this, list);
        list_ExerciesListenSumTop.setAdapter(adapter);

        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT WordOne,WordTwo,WordTrue,Status,ID,Result FROM ExcerciseSumListen  where ID_Level=? ", new String[]{Result});
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String word_True = cursor.getString(0);
            String word_False = cursor.getString(1);
            String WordTrue = cursor.getString(2);
            String Status = cursor.getString(3);
            String ID = cursor.getString(4);
            String Result = cursor.getString(5);
            list.add(new Class_ExerciesListen(word_True,word_False,WordTrue,Status,ID,Result));


        }
        adapter.notifyDataSetChanged();
        ClickRefresh();
    }
    private void ClickRefresh() {
        btn_Reload_SUMTOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
        btn_btn_Reload_SUMTOPUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("Status", "null");
                contentValues.put("Result", "null");

                SQLiteDatabase database = Database.initDatabase(ListExercisListenLevelTop.this, "thth.sqlite");
                database.update("ExcerciseSumListen", contentValues, "ID_Level = ?", new String[]{Result});
                adapter.notifyDataSetChanged();
            }
        });
    }
}
