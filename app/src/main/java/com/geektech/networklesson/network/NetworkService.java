package com.geektech.networklesson.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.geektech.networklesson.base.callback.JsonCallback;
import com.geektech.networklesson.base.callback.StringCallback;

import org.json.JSONObject;

// Created by askar on 10/9/18.
public class NetworkService implements NetworkServiceContract {

    //region Static

    private static NetworkService INSTANCE;

    public static NetworkServiceContract getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new NetworkService(context);
        }

        return INSTANCE;
    }

    //endregion

    private NetworkService(Context context){
        queue = Volley.newRequestQueue(context);
    }

    private RequestQueue queue;

    //region Contract

    @Override
    public void getJson(String url, final JsonCallback callback) {
        JsonObjectRequest jsonRequest =
                new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                callback.onSuccess(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                callback.onFail(error.getMessage());
                            }
                        });

        queue.add(jsonRequest);
    }

    @Override
    public void getString(String url, final StringCallback callback) {
        StringRequest stringRequest = new StringRequest (
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onFail(error.getMessage());
                    }
                }
        );

        queue.add(stringRequest);
    }

    //endregion
}
