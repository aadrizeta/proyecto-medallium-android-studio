package com.finalproyect.medallium.domain.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DatosCombate implements Serializable {

    private int id_datoscombate;
    @SerializedName("fuerza")
    private int fuerza;
    @SerializedName("defensa")
    private int defensa;
    @SerializedName("puntosVida")
    private int puntosVida;
    @SerializedName("velocidad")
    private int velocidad;
    @SerializedName("espiritacion")
    private int espiritacion;
    @SerializedName("total")
    private int total;
    @SerializedName("yokai")
    private Yokai yokai;
    @SerializedName("habilidad")
    private String habilidad;

    public int getId_datoscombate() {
        return id_datoscombate;
    }

    public void setId_datoscombate(int id_datoscombate) {
        this.id_datoscombate = id_datoscombate;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEspiritacion() {
        return espiritacion;
    }

    public void setEspiritacion(int espiritacion) {
        this.espiritacion = espiritacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Yokai getYokai() {
        return yokai;
    }

    public void setYokai(Yokai yokai) {
        this.yokai = yokai;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
}
