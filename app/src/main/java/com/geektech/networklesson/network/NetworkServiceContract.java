package com.geektech.networklesson.network;

import com.geektech.networklesson.base.callback.JsonCallback;
import com.geektech.networklesson.base.callback.StringCallback;

// Created by askar on 10/9/18.
public interface NetworkServiceContract {
    void getJson(String url, JsonCallback callback);

    void getString(String url, StringCallback callback);
}
