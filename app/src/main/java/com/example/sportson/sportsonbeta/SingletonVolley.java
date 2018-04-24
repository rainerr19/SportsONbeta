package com.example.sportson.sportsonbeta;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Rainer on 24/04/2018.
 */

public class SingletonVolley {
    private static SingletonVolley instanceVolley;// se intancia la clase
    private RequestQueue requestQueue; // peticion
    private static Context ctx; // contexto

    private SingletonVolley(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

    }

    public com.android.volley.RequestQueue getRequestQueue() {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());

        }
        return requestQueue;
    }

    public static SingletonVolley getInstanceVolley(Context ctx) {
        if (instanceVolley == null) {
            instanceVolley = new SingletonVolley(ctx);
        }
        return instanceVolley;
    }
    public <T> void addToRequestQueue(Request<T> requestQueue) {
        getRequestQueue().add(requestQueue);
    }


}
