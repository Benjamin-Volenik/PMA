package com.example.lv1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseAPIService {

    @GET("/v1/courses")
    Call<ArrayList<CourseModel>> getCourses();
}
