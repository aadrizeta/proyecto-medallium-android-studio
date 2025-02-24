package com.finalproyect.medallium.interfaces;

import com.finalproyect.medallium.domain.entities.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/api/users/create")
    Call<Users.User> registerUser(@Body Users.User user);

    @POST("/api/users/login")
    Call<Users.User> loginUser(@Body Users.User user);
}
