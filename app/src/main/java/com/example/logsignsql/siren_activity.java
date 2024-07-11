package com.example.logsignsql;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class siren_activity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button btnPlayP;
    boolean isPlaying=false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siren);

        //initialize the MediaPlayer with audio file
        mediaPlayer = MediaPlayer.create(this,R.raw.ps);
        btnPlayP = findViewById(R.id.btnPlayP);

        btnPlayP.setOnClickListener(view -> {
            if(isPlaying){
                //if music is playing,pause it
                mediaPlayer.pause();
                isPlaying=false;
                btnPlayP.setText("Play");
            }
            else{
                //if music is not playing , start playing it
                mediaPlayer.start();
                isPlaying=true;
                btnPlayP.setText("Pause");
            }

        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer=null;
    }

}
