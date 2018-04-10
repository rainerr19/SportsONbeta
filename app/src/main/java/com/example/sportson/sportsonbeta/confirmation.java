package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Toolbar myToolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //boton de retorno
        Button conf = (Button) findViewById(R.id.btn_conf);
        final EditText texcode = (EditText) findViewById(R.id.ccode);
        Intent intent = getIntent();
        final String cod = intent.getStringExtra("mcode");
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //confirmar codigo para ingresar datos a la base de datos
                if(cod.equals(texcode.getText().toString())){
                   Toast.makeText(getApplicationContext(), "Code confirm!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "code are no the same", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
