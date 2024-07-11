package com.example.logsignsql;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class helpline_activity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        Button btn_call = findViewById(R.id.btn_call);
        btn_call.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:100"));
            startActivity(intent);
        });
        Button hosp = findViewById(R.id.hosp);
        hosp.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:102"));
            startActivity(intent);
        });
        Button women_distress = findViewById(R.id.women_distress);
        women_distress.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:1091"));
            startActivity(intent);
        });
        Button stud_abuse = findViewById(R.id.stud_abuse);
        stud_abuse.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:1098"));
            startActivity(intent);
        });
    }
}