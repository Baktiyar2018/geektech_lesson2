package com.geektech.networklesson.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

// Created by askar on 10/9/18.
public class DogModel {
    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    @SerializedName("image")
    private String image;

    public static DogModel fromJson(JSONObject jsonObject){
        Gson gson = new Gson();
        return gson.fromJson(
                jsonObject.toString(),
                DogModel.class
        );
    }

    public DogModel(String name, int age, String image){
        this.name = name;
        this.age = age;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + image;
    }
}
