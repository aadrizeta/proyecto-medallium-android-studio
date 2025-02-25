package com.finalproyect.medallium.domain.entities;

import com.google.gson.annotations.SerializedName;

public class Rango {
    private int id_Rango;
    private String name;
    private String descripcion;
    private String caracteristicasGenerales;
    private String tipoBonus;
    private String image;

    // Getters y setters


    public int getId_Rango() {
        return id_Rango;
    }

    public void setId_Rango(int id_Rango) {
        this.id_Rango = id_Rango;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicasGenerales() {
        return caracteristicasGenerales;
    }

    public void setCaracteristicasGenerales(String caracteristicasGenerales) {
        this.caracteristicasGenerales = caracteristicasGenerales;
    }

    public String getTipoBonus() {
        return tipoBonus;
    }

    public void setTipoBonus(String tipoBonus) {
        this.tipoBonus = tipoBonus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}