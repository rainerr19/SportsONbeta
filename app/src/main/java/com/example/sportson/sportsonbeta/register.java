package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class register extends AppCompatActivity  {
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        //getSupportActionBar().setTitle(R.string.reg);// titulo
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //boton de retorno

        final String correoEmpresa = "sportsoncol@gmail.com";
        final String passwordEmpresa= "barranquilla10";
        final Session[] session = new Session[1];
        codeGenerate code = new codeGenerate();
        final String cod = code.GenerateC(10);

        btn_next = (Button) findViewById(R.id.btn_next) ;

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_next.setVisibility(btn_next.GONE);

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                //si el editText esta vacio
                EditText NameEdit = (EditText) findViewById(R.id.NameEdit);
                EditText nmail = (EditText) findViewById(R.id.nmail);
                EditText Cel = (EditText) findViewById(R.id.Cel);
                EditText AgeIn = (EditText)findViewById(R.id.AgeIn);
                EditText npass = (EditText) findViewById(R.id.npass);
                EditText cpass = (EditText) findViewById(R.id.cpass);
                RadioButton woma = (RadioButton) findViewById(R.id.woman);
                RadioButton man = (RadioButton) findViewById(R.id.man);
                String name = NameEdit.getText().toString();
                String sexo;
                if (name.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a username", Toast.LENGTH_SHORT).show();
                    NameEdit.requestFocus();// focus en el editText
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
                name = nmail.getText().toString();
                if (name.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a Email", Toast.LENGTH_SHORT).show();
                    nmail.requestFocus();
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
                name = Cel.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter a Cell phone number",Toast.LENGTH_SHORT).show();
                    Cel.requestFocus();
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
                name = AgeIn.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter a Age",Toast.LENGTH_SHORT).show();
                    AgeIn.requestFocus();
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
                if (man.isChecked()) {
                    sexo = "1";
                }else {
                    if(woma.isChecked()){
                        sexo = "0";
                    }else{
                        Toast.makeText(getApplicationContext(),"You did select sex",Toast.LENGTH_SHORT).show();
                        btn_next.setVisibility(btn_next.VISIBLE);

                        return;
                    }
                }

                name = npass.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter new password",Toast.LENGTH_SHORT).show();
                    npass.requestFocus();
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
                name = cpass.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter a password confirmation",Toast.LENGTH_SHORT).show();
                    cpass.requestFocus();
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
                // string1.equals(string2)--> string1 == string2
                String name1 = npass.getText().toString();

                String mensaje = getString(R.string.EmailTex1) +" " + NameEdit.getText()+ "\n" + "\n"
                        + getString(R.string.EmailTex2)+ " "+ cod;

                if (name.equals(name1)) {
                    //Toast.makeText(getApplicationContext(),"Sending a confirmation code...",Toast.LENGTH_SHORT).show();

                    Properties properties = new Properties();
                    properties.put("mail.smtp.host","smtp.googlemail.com");
                    properties.put("mail.smtp.socketFactoy.port","465");
                    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.smtp.auth","true");
                    properties.put("mail.smtp.port","465");
                    String emailDeti = nmail.getText().toString();
                    try { session[0] = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correoEmpresa,passwordEmpresa);
                        }
                    });
                        if (session[0] != null){
                            javax.mail.Message message = new MimeMessage(session[0]);
                            message.setFrom(new InternetAddress(correoEmpresa));
                            message.setSubject("confirmación de correo");
                            message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(emailDeti));
                            message.setContent(mensaje,"text/plain");
                            Transport.send(message);

                        }

                    }catch (Exception e){
                        e.printStackTrace();
                        return;
                    }
                    //carga.hide();
                    Intent intent = new Intent(getApplicationContext(),confirmation.class);
                    String mData[] = {NameEdit.getText().toString(),Cel.getText().toString(),
                            AgeIn.getText().toString(),npass.getText().toString(),nmail.getText().toString(),cod,sexo};

                    intent.putExtra("mdata",mData);
                    startActivity(intent);
                }else{

                    Toast.makeText(getApplicationContext(),"Password are not the same",Toast.LENGTH_SHORT).show();
                    npass.requestFocus();
                    btn_next.setVisibility(btn_next.VISIBLE);

                    return;
                }
            }
        });

    }
}
