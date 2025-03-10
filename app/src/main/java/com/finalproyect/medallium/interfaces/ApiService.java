package com.finalproyect.medallium.interfaces;

import com.finalproyect.medallium.domain.entities.DatosCombate;
import com.finalproyect.medallium.domain.entities.DetallesYokai;
import com.finalproyect.medallium.domain.entities.Elemento;
import com.finalproyect.medallium.domain.entities.LoginRequest;
import com.finalproyect.medallium.domain.entities.Rango;
import com.finalproyect.medallium.domain.entities.Tribus;
import com.finalproyect.medallium.domain.entities.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {

    @POST("/api/users/create")
    Call<Users.User> registerUser(@Body Users.User user);

    @POST("/api/users/login")
    Call<Users.User> loginUser(@Body LoginRequest request);

    @GET("/api/detalles/get-detallesYokai")
    Call<List<DetallesYokai>> getDetallesYokai();

    @GET("/api/datosCombate/get-tDatosCombate")
    Call<List<DatosCombate>> getDatosCombate();

    @GET("/api/tribus/get-tribus")
    Call<List<Tribus>> getTribus();

    @GET("/api/elemento/get-all-elementos")
    Call<List<Elemento>> getAllElementos();

    @POST("/api/datosCombate/getDatosCombateByName")
    Call<DatosCombate> getDatosCombateByName(@Query("nombre") String nombre);

    @GET("/api/rango/get-rango")
    Call<List<Rango>> getRango();

    @GET("/api/detalles/getByRango/{idRango}")
    Call<List<DetallesYokai>> getByRango(@Path("idRango") int idRango);

    @GET("/api/detalles/getByElemento/{idElemento}")
    Call<List<DetallesYokai>> getByElemento(@Path("idElemento") int idElemento);

    @GET("/api/detalles/getByTribu/{idTribu}")
    Call<List<DetallesYokai>> getByTribu(@Path("idTribu") int idTribu);

}
