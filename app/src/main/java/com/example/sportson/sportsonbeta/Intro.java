package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Intro extends AppCompatActivity {
    Button bt_reg;
    Button btn_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        bt_reg = (Button) findViewById(R.id.btn_reg);
        btn_in = (Button) findViewById(R.id.btn_inicio);

        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para abrir nueva actividad
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });
        btn_in.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                EditText use = (EditText) findViewById(R.id.Us);
                EditText pa = (EditText) findViewById(R.id.PassU);
                String userdata = use.getText().toString();

                if (userdata.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a Email or cell phone number", Toast.LENGTH_SHORT).show();
                    use.requestFocus();// focus en el editText
                    return;
                }
                userdata = pa.getText().toString();
                if (userdata.matches("")){
                    Toast.makeText(getApplicationContext(), "You did not enter a password", Toast.LENGTH_SHORT).show();
                    pa.requestFocus();// focus en el editText
                    return;
                    }
            }
        });
    }
}