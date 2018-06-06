package com.example.thu.hayda.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.thu.hayda.Class_ExerciesRead;
import com.example.thu.hayda.Database;
import com.example.thu.hayda.R;
import com.example.thu.hayda.adapter.AdapterExerciesRead;

import java.util.ArrayList;

public class ListExerciesReadSum extends AppCompatActivity {
    final String DATABASE_NAME = "thth.sqlite";
    SQLiteDatabase database;
    ListView list_ExerciesreadSum;

    ArrayList<Class_ExerciesRead> list;
    AdapterExerciesRead adapter;

    String Result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercies_read_sum);

        list_ExerciesreadSum=findViewById(R.id.list_ExerciesreadSum);

        Intent intent = getIntent();
        Result = intent.getStringExtra("ID");

        list = new ArrayList<>();
        adapter = new AdapterExerciesRead(ListExerciesReadSum.this, list);
        list_ExerciesreadSum.setAdapter(adapter);

        database = Database.initDatabase(this, DATABASE_NAME);
//           Cursor cursor = database.rawQuery("select * from word ", null);
        Cursor cursor = database.rawQuery("SELECT Word FROM ExcerciseSumRead  where ID_Level=? ", new String[]{Result});
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String word = cursor.getString(0);
            list.add(new Class_ExerciesRead(word));


        }
        adapter.notifyDataSetChanged();
    }
}
