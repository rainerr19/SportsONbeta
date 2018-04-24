package com.example.sportson.sportsonbeta;

import com.android.volley.Request;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



/**
 * Created by Rainer on 20/04/2018.
 */
public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL="http://192.168.1.6/SportsOnEdit/login.php";
    private Map<String,String> params;
    public LoginRequest(String data,String pass,Boolean mail_cel, Listener<String>listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        if (mail_cel){
            params.put("data",data);
        }else{
            params.put("data",data);
        }
        params.put("contr",pass);
        params.put("mail_cel",mail_cel.toString());
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
