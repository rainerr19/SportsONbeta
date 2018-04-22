package com.example.sportson.sportsonbeta;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rainer on 17/04/2018.
 */

public class registerRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="http://192.168.1.6/SportsOnEdit/registro.php";
    private Map<String,String> params;
    public registerRequest(String name, String cel, String age, String pass, String mail,String sex, Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("celular",cel);
        params.put("edad",age);
        params.put("contr",pass);
        params.put("email",mail);
        params.put("se",sex);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
