package com.finalproyect.medallium;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
public interface ApiService {

    @POST("/api/users/create")
    Call<Users.User> registerUser(@Body Users.User user);

    @POST("/api/users/login")
    Call<Users.User> loginUser(@Body Users.User user);
}
