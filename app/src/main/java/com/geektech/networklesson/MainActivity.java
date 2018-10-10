package com.geektech.networklesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geektech.networklesson.base.callback.JsonCallback;
import com.geektech.networklesson.model.DogModel;
import com.geektech.networklesson.network.NetworkService;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView;

    //region Lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //endregion

    //region Private

    private void init(){
        imageView = findViewById(R.id.main_dog_image);

        loadData();
    }

    private void loadData(){
        String url = "http://www.mocky.io/v2/5bbcc2cd3200007c0027ee46";
        NetworkService
                .getInstance(getApplicationContext())
                .getJson(url, new JsonCallback() {
                    @Override
                    public void onSuccess(JSONObject result) {
                        DogModel dog = DogModel.fromJson(result);
                        Log.d("ololo", dog.toString());

                        uploadImage(dog.getImage());
                    }

                    @Override
                    public void onFail(String message) {
                        Log.d("ololo", message);
                    }
                });
    }

    private void uploadImage(String url){
        Glide.with(this)
                .load(url)
                .into(imageView);
    }

    //endregion
}
