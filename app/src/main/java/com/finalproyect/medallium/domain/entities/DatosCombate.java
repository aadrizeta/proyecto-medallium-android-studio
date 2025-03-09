package com.finalproyect.medallium.domain.entities;

public class DatosCombate {

    private int id_datoscombate;
    private int fuerza;
    private int defensa;
    private int puntos_vida;
    private int velocidad;
    private int espiritacion;
    private int total;
    private Yokai yokai;
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

    public int getPuntos_vida() {
        return puntos_vida;
    }

    public void setPuntos_vida(int puntos_vida) {
        this.puntos_vida = puntos_vida;
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
