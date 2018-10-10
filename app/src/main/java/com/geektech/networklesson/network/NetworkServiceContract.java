package com.geektech.networklesson.network;

import org.json.JSONObject;

// Created by askar on 10/9/18.
public interface NetworkServiceContract {
    void getJson(String url, ResponseCallback<JSONObject> callback);

    void getString(String url, ResponseCallback<String> callback);
}
