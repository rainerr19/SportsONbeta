package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Intro extends AppCompatActivity {
    Button bt_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        bt_reg = (Button) findViewById(R.id.btn_reg);
        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para abrir nueva actividad
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });

    }
}
