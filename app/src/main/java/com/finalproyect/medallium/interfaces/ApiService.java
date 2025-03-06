package com.finalproyect.medallium.interfaces;

import com.finalproyect.medallium.domain.entities.DetallesYokai;
import com.finalproyect.medallium.domain.entities.Elemento;
import com.finalproyect.medallium.domain.entities.LoginRequest;
import com.finalproyect.medallium.domain.entities.Rango;
import com.finalproyect.medallium.domain.entities.Tribus;
import com.finalproyect.medallium.domain.entities.Users;
import com.finalproyect.medallium.ui.views.RangosScreen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {

    @POST("/api/users/create")
    Call<Users.User> registerUser(@Body Users.User user);

    @POST("/api/users/login")
    Call<Users.User> loginUser(@Body LoginRequest request);

    @GET("/api/detalles/get-detallesYokai")
    Call<List<DetallesYokai>> getDetallesYokai();

    @GET("/api/tribus/get-tribus")
    Call<List<Tribus>> getTribus();

    @GET("/api/elemento/get-all-elementos")
    Call<List<Elemento>> getAllElementos();

    @GET("/api/rango/get-rango")
    Call<List<Rango>> getRango();

}
