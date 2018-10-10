package com.geektech.networklesson.network;

// Created by askar on 10/9/18.
public interface ResponseCallback<T> {
    void onSuccess(T result);

    void onFail(String message);
}
