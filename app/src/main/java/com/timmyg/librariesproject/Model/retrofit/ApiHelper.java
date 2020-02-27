package com.timmyg.librariesproject.model.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.timmyg.librariesproject.model.entity.Photo;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {

    public static final String BASE_URL = "https://pixabay.com";
    public static final String KEY = "14151331-73f45b484bf0cb29a490fc1a6";

    public Observable<Photo> requestServer(){
        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        RxJava2CallAdapterFactory rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();

        ApiService api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(ApiService.class);

        return api.getPhoto(KEY).subscribeOn(Schedulers.io());


    }
}
