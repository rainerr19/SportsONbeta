package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.RequestQueue;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class confirmation extends AppCompatActivity {
    //RequestQueue request;
    String[] mData;
    //ProgressDialog carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        Toolbar myToolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //boton de retorno
        Button conf = (Button) findViewById(R.id.btn_conf);
        final EditText texcode = (EditText) findViewById(R.id.ccode);
        //EditText name = (EditText) findViewById(R.id.NameEdit);
        //Log.d("nose",name.getText().toString());
        Intent intent = getIntent();
        //se recibe una cadena con todos los datos del usuario
        // 1.nombre  2.cel 3.age 4.pass 5.mail 6.cod 7. sex
        mData = intent.getStringArrayExtra("mdata");
        final String cod = mData[5];

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mData[0] ,cel = mData[1],age = mData[2],pass = mData[3], mail = mData[4],sex = mData[6];
                //confirmar codigo para ingresar datos a la base de datos

                if(cod.equals(texcode.getText().toString())){

                Response.Listener<String> ResponListener  = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json_respon = new JSONObject(response);
                            boolean success = json_respon.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(), "Code confirm!! and register", Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(getApplicationContext(),Intro.class);
                                startActivity(intent2);
                                finish();
                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                                builder.setMessage("Error en registro").setNegativeButton("Retry",null).create().show();

                                //Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {

                            Toast.makeText(getApplicationContext(), "Error"+e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }
                };
                registerRequest registro = new registerRequest(name,cel,age,pass,mail,sex,ResponListener);
                //RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                //queue.add(registro);
                    SingletonVolley.getInstanceVolley(getApplicationContext()).addToRequestQueue(registro);
                }else{
                    Toast.makeText(getApplicationContext(), "code are no the same", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
