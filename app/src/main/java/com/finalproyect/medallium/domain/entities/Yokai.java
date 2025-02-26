package com.finalproyect.medallium.domain.entities;

import com.google.gson.annotations.SerializedName;

public class Yokai {
    private int id_Yokai;
    private String name;
    private Rango rango;
    private Tribus tribu;
    private Elemento elemento;


    public int getId_Yokai() {
        return id_Yokai;
    }

    public void setId_Yokai(int id_Yokai) {
        this.id_Yokai = id_Yokai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public Tribus getTribu() {
        return tribu;
    }

    public void setTribu(Tribus tribu) {
        this.tribu = tribu;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

}
