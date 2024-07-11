package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent main = new Intent(SplashScreenActivity.this,LoginActivity.class);


        new Handler().postDelayed(() -> {

            startActivity(main);
            finish();

        },3500);
    }
}
