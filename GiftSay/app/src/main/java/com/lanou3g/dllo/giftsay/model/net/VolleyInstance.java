package com.lanou3g.dllo.giftsay.model.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lanou3g.dllo.giftsay.ui.app.GiftSayApp;

/**
 * Created by dllo on 16/9/12.
 * 网络请求单例
 */
public class VolleyInstance {
    private static VolleyInstance instance;
    private RequestQueue requestQueue;

    private VolleyInstance(){
        requestQueue = Volley.newRequestQueue(GiftSayApp.getContext());
    }
    public static VolleyInstance getInstance(){
        if (instance == null){
            synchronized (VolleyInstance.class){
                if (instance == null){
                    instance = new VolleyInstance();
                }
            }
        }
        return instance;
    }

    // 对外提供请求方法
    public void startRequest(String url,final VolleyResult result){
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                result.failure();
            }
        });
        requestQueue.add(sr);
    }

}
