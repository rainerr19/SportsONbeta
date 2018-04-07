package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(R.string.reg);// titulo
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//boton de retorno

        btn_next = (Button) findViewById(R.id.btn_next) ;
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si el editText esta vacio
                EditText NameEdit = (EditText) findViewById(R.id.NameEdit);
                EditText nmail = (EditText) findViewById(R.id.nmail);
                EditText Cel = (EditText) findViewById(R.id.Cel);
                EditText AgeIn = (EditText)findViewById(R.id.AgeIn);
                EditText npass = (EditText) findViewById(R.id.npass);
                EditText cpass = (EditText) findViewById(R.id.cpass);

                String name = NameEdit.getText().toString();
                if (name.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a username", Toast.LENGTH_SHORT).show();
                    NameEdit.requestFocus();// focus en el editText
                    return;
                }
                name = nmail.getText().toString();
                if (name.matches("")) {
                    Toast.makeText(getApplicationContext(), "You did not enter a Email", Toast.LENGTH_SHORT).show();
                    nmail.requestFocus();
                    return;
                }
                name = Cel.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter a Cell phone number",Toast.LENGTH_SHORT).show();
                    Cel.requestFocus();
                    return;
                }
                name = AgeIn.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter a Age",Toast.LENGTH_SHORT).show();
                    AgeIn.requestFocus();
                    return;
                }
                name = npass.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter new password",Toast.LENGTH_SHORT).show();
                    npass.requestFocus();
                    return;
                }
                name = cpass.getText().toString();
                if (name.matches("")){
                    Toast.makeText(getApplicationContext(),"You did not enter a password confirmation",Toast.LENGTH_SHORT).show();
                    cpass.requestFocus();
                    return;
                }
                // string1.equals(string2)--> string1 == string2
                String name1 = npass.getText().toString();
                if (name.equals(name1)) {
                    Intent intent = new Intent(getApplicationContext(),confirmation.class);
                    startActivity(intent);
                }else{

                    Toast.makeText(getApplicationContext(),"Password are not the same",Toast.LENGTH_SHORT).show();
                    npass.requestFocus();
                    return;
                }
            }
        });

    }
}
