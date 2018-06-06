package com.example.thu.hayda.activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thu.hayda.DictionaryModel;
import com.example.thu.hayda.R;

import java.util.ArrayList;
import java.util.Locale;

class AdapterWord extends BaseAdapter {
    Activity context;
    ArrayList<DictionaryModel> list;
    TextView txt_result;
    TextToSpeech textToSpeech;
    ImageView img_micro;



    public AdapterWord(Activity context, ArrayList<DictionaryModel> list) {
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
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.wordlist, null);

        final TextView id_word = (TextView) row.findViewById(R.id.id_word);
        TextView txt_ipa = (TextView) row.findViewById(R.id.txt_ipa);
        TextView txt_define = (TextView) row.findViewById(R.id.txt_define);
        txt_result = (TextView) row.findViewById(R.id.txt_result);
        img_micro = (ImageView) row.findViewById(R.id.img_micro);
        ImageView img_giongmy = (ImageView) row.findViewById(R.id.img_giongmy);


        final DictionaryModel dictionaryModel = list.get(position);
        id_word.setText(dictionaryModel.getWord() + "");
        txt_ipa.setText(dictionaryModel.getIpa());
        txt_define.setText(dictionaryModel.getMean());
        //micro.
        img_micro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi dialog chứa man hình thu âm.
                Intent intent = new Intent(context,DiglogRecord.class);
                intent.putExtra("Word",dictionaryModel.getWord());
                intent.putExtra("Mean",dictionaryModel.getIpa());
                context.startActivity(intent);
            }
        });

//loa thu am click
        img_giongmy.setOnClickListener(new View.OnClickListener() {
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
                                textToSpeech.speak(id_word.getText().toString(), textToSpeech.QUEUE_FLUSH, null, null);

                            } else
                                textToSpeech.speak(id_word.getText().toString(), textToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });

        return row;
    }

}