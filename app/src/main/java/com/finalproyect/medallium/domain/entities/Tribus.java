package com.finalproyect.medallium.domain.entities;

import com.google.gson.annotations.SerializedName;

public class Tribus {
    private int id_Tribu;
    private String nombre;
    private String caracteristicasGenerales;
    private String tipoBonus;
    private String descripcion;
    private String image;
    private String imagenPixel;
    private String nombreJapones;

    // Getters y setters


    public int getId_Tribu() {
        return id_Tribu;
    }

    public void setId_Tribu(int id_Tribu) {
        this.id_Tribu = id_Tribu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getImagenPixel() {
        return imagenPixel;
    }

    public void setImagenPixel(String imagenPixel) {
        this.imagenPixel = imagenPixel;
    }

    public String getNombreJapones() {
        return nombreJapones;
    }

    public void setNombreJapones(String nombreJapones) {
        this.nombreJapones = nombreJapones;
    }
}