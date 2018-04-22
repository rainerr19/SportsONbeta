package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class perfilActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        TextView tv_nombre = (TextView) findViewById(R.id.text_nom);
        TextView tv_edad = (TextView) findViewById(R.id.text_age);
        TextView tv_sex = (TextView) findViewById(R.id.text_sex);
        TextView tv_id = (TextView) findViewById(R.id.text_iduser);
        TextView tv_cel = (TextView) findViewById(R.id.text_cel);
        TextView tv_mail = (TextView) findViewById(R.id.text_mail);
        Intent intent = getIntent();
        //se recibe una cadena con todos los datos del usuario
        // 0 name 1.edad 2.sex 3.pass 4.cel 5.email
        String[] userData = intent.getStringArrayExtra("userdata");
        tv_nombre.setText("Nombre: " + userData[0]+ " ");
        tv_edad.setText("Edad: " + userData[1] + "años");
        if (userData[2].matches("1")) {
            tv_sex.setText("Sexo: Masculino");
        }else {
            tv_sex.setText("Sexo: Femenino");

        }
        tv_id.setText("Id_usuario: " + userData[6]+ "-"+ userData[3]);
        tv_cel.setText("Celular: " + userData[4] + " ");
        tv_mail.setText("Email: " + userData[5]+ " ");


    }
}
