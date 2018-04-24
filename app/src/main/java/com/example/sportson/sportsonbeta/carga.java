package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class carga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_carga);
                Intent intent = new Intent(getApplicationContext(),Intro.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}
