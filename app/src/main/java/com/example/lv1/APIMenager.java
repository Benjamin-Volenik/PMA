package com.example.lv1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIMenager {

    static APIMenager instance;
    private CourseAPIService service;
    private APIMenager(){
        Retrofit.Builder builder = new Retrofit.Builder();
        //postavljanje retrofit-a
        Retrofit retrofit = builder.baseUrl("http://api.dataatwork.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CourseAPIService.class);
    }
    public static APIMenager getInstance(){
        if (instance == null){
            instance = new APIMenager();
        }
        return instance;
    }
    public CourseAPIService service(){
        return service;
    }
}
