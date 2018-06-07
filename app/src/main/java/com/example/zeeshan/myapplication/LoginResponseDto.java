package com.example.zeeshan.myapplication;

import com.google.gson.annotations.SerializedName;

public class LoginResponseDto {

    @SerializedName("name")
    private String name;
    @SerializedName("password")
    private String password;

}
