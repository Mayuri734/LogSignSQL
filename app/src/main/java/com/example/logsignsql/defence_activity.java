package com.example.logsignsql;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class defence_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defence);

        VideoView videoView = findViewById(R.id.videoView1);


        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.defencevdo);

        videoView.start();

        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
    }
}
