package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button help = findViewById(R.id.btn_helpline);
        Button siren1 = findViewById(R.id.siren);
        Button def = findViewById(R.id.defence1);
        Button cont = findViewById(R.id.btn_contact);
        Button track = findViewById(R.id.trackMe);
        help.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,helpline_activity.class);
            startActivity(intent);
        });

        siren1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,siren_activity.class);
            startActivity(intent);
        });

        def.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,defence_activity.class);
            startActivity(intent);
        });

        cont.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ContactActivity.class);
            startActivity(intent);
        });


        track.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);
        });



    }
}
