package com.example.thu.hayda.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.thu.hayda.R;
import com.example.thu.hayda.youtube.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class Main_YoutubeAPI extends YouTubeBaseActivity {

    YouTubePlayerView myouTubePlayerView;
    YouTubePlayer.OnInitializedListener monInitializedListener;
    private static final String TAG = "Main_YoutubeAPI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__youtube_api);
        AddControls();

        Intent t = getIntent();
        final String _value = getIntent().getStringExtra("Link_video");


        monInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(_value);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        myouTubePlayerView.initialize(YoutubeConfig.getApiKey(), monInitializedListener);
    }

    private void AddControls() {
        myouTubePlayerView = findViewById(R.id.view);
    }
}
