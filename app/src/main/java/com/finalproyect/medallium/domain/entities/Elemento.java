package com.finalproyect.medallium.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Elemento implements Serializable {
    private int id_Elemento;
    private String fortaleza;
    private String debilidad;
    private String descripcion;
    private String image;
    private String nombre;

    public int getId_Elemento() {
        return id_Elemento;
    }

    public void setId_Elemento(int id_Elemento) {
        this.id_Elemento = id_Elemento;
    }

    public String getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(String fortaleza) {
        this.fortaleza = fortaleza;
    }

    public String getDebilidad() {
        return debilidad;
    }

    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}