package com.example.loginmvvm.model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface RetroInterface {
    @POST("users")
    @Headers({"Accept:application/json","content-Type:application/json","Authorization:Bearer 3159ac647f88608910b12fae5d8cac46d45f77f9a2c6c8c88d8b39629a92369e"})
    Call<UserResponse>createUser(@Body User params);
}

