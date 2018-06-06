package com.example.thu.hayda.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thu.hayda.Class_ExerciesRead;
import com.example.thu.hayda.DictionaryModel;
import com.example.thu.hayda.R;
import com.example.thu.hayda.activity.DiglogRecord;

import java.util.ArrayList;

public class AdapterExerciesRead extends BaseAdapter {
    Activity context;
    ArrayList<Class_ExerciesRead> list;

    public AdapterExerciesRead(Activity context, ArrayList<Class_ExerciesRead> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_adapter_exerciesread, null);


        TextView txt_Word = (TextView) row.findViewById(R.id.txt_word1);
        ImageButton img_voice =  row.findViewById(R.id.img_voice);



        final Class_ExerciesRead class_exerciesRead = list.get(position);
        txt_Word.setText(class_exerciesRead.getWord());

        img_voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DiglogRecord.class);
                intent.putExtra("Word",class_exerciesRead.getWord());
                context.startActivity(intent);
            }
        });
        return row;
    }
}
