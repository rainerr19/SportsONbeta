package com.example.sportson.sportsonbeta;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class sesion_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, cancha.OnFragmentInteractionListener, perfil_usuario.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        // fragment inicial
        Fragment fi = new cancha();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_sesion_,fi).commit();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sesion_, menu);
        TextView tv_nombre = (TextView) findViewById(R.id.text_name);
        TextView tv_mail = (TextView) findViewById(R.id.text_email);

        Intent intent = getIntent();
        //se recibe una cadena con todos los datos del usuario
        // 0 name 1.edad 2.sex 3.pass 4.cel 5.email
        String[] userData = intent.getStringArrayExtra("userdata");
        tv_nombre.setText(userData[0]);
        tv_mail.setText(userData[5]);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /*
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
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment f = null;
        boolean selec = false;

        if (id == R.id.nav_camera) {
            // Handle the camera action
            f = new cancha();
            selec = true;
        } else if (id == R.id.nav_gallery) {
            f = new perfil_usuario();
            selec = true;

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }
        if(selec){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_sesion_,f).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
