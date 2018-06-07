package com.example.zeeshan.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Users {

    @GET("users")
    Call<List<User>> getUserDetails();
}
