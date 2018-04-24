package com.example.sportson.sportsonbeta;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
public class Intro extends AppCompatActivity {
    Button bt_reg;
    Button btn_in;
    boolean salir = false;
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(salir){
            Intent intentOut = new Intent(Intent.ACTION_MAIN);//tart as a main entry point, does not expect to receive data.
            //ACTION_MAIN with category CATEGORY_HOME -- Launch the home screen.
            intentOut.addCategory(Intent.CATEGORY_HOME);//is the first activity that is displayed when the device boots
            intentOut.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            /**If set, and the activity being launched is already running in the current task,
             then instead of launching a new instance of that activity,
             all of the other activities on top of it will be closed and
             this Intent will be delivered to the (now on top) old activity as a new Intent.
            * */
            startActivity(intentOut);
            finish();//termina activity actual
            System.exit(0);//sale del sistema
        }
        Toast.makeText(getApplicationContext(),"Press again to exit.",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                salir = false;
            }
        },3000);
        salir = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        bt_reg = (Button) findViewById(R.id.btn_reg);
        btn_in = (Button) findViewById(R.id.btn_inicio);
        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });
        //button in-------------------------------------
        btn_in.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText use = (EditText) findViewById(R.id.Us);
                EditText pa = (EditText) findViewById(R.id.PassU);
                final String mail_cel = use.getText().toString();
                final String pass = pa.getText().toString();

                if (mail_cel.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a Email or cell phone number", Toast.LENGTH_SHORT).show();
                    use.requestFocus();// focus en el editText
                    return;

                }
                if (pass.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a password", Toast.LENGTH_SHORT).show();
                    pa.requestFocus();// focus en el editText
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                String name = jsonResponse.getString("name");
                                String eda = jsonResponse.getString("age");
                                int sex = jsonResponse.getInt("sex");
                                String pass = jsonResponse.getString("password");
                                String cel = jsonResponse.getString("cel");
                                String email = jsonResponse.getString("mail");
                                int idUser = jsonResponse.getInt("id_user");
                                Intent intent2 = new Intent(getApplicationContext(),perfilActivity.class);
                                String mData[] = {name,eda,String.valueOf(sex),pass,cel,email,String.valueOf(idUser)};
                                intent2.putExtra("userdata",mData);
                                startActivity(intent2);
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(), "Error:Password o usuario incorrecta", Toast.LENGTH_SHORT).show();
                            //AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                            //builder.setMessage("Error Login").setNegativeButton("Retry",null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(mail_cel,pass,no_mail(mail_cel),responseListener);
                //RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                //queue.add(loginRequest);
                SingletonVolley.getInstanceVolley(getApplicationContext()).addToRequestQueue(loginRequest);
            }
        });

    }

    private Boolean no_mail(String cadena){
        int value = cadena.indexOf("@");
        if (value > 0){
            return true;
        }else {
            return false;
        }
    }
}