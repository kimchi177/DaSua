package com.example.thu.hayda.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.thu.hayda.R;
import com.example.thu.hayda.activity.MainActivity_LearnSpeak;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    //vars
//    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Integer> mImageUrls, ArrayList<String> mNames) {

        this.mContext = mContext;
        this.mImageUrls = mImageUrls;
        this.mNames = mNames;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.image.setImageResource(mImageUrls.get(position));

            holder.txt_idIpa.setText(mNames.get(position));



        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t = new Intent(mContext, MainActivity_LearnSpeak.class);
                t.putExtra("id_Ipa", holder.txt_idIpa.getText().toString());
//                Toast.makeText(mContext, holder.txt_idIpa.getText().toString(), Toast.LENGTH_SHORT).show();

                mContext.startActivity(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_idIpa;
        CircleImageView image;


        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            txt_idIpa = itemView.findViewById(R.id.txt_idIpa);
            txt_idIpa.setVisibility(View.INVISIBLE);

        }
    }
}