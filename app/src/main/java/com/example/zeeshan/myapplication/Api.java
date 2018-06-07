package com.example.zeeshan.myapplication;

import com.example.zeeshan.myapplication.User;

import java.util.List;


import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "http://192.168.0.101:8080/messenger/webapi/";


    @GET("messages")
    Call<String> getMessage();


    @GET("users")
    Call<List<User>> getUsers();

    @GET("login")
        //"/?name={name}&password={password}")
    Call<String> login(@Query("name") String name, @Query("password") String password);


    // Call<String> login(@Query("username") String name,@Query("pass") String password);




}
