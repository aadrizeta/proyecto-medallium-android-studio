package com.finalproyect.medallium.domain.entities;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DetallesYokai implements Serializable {
    private int id_detallesYokai;
    private String createdAt;
    private String updatedAt;
    private String image;
    private String medalla;
    private String comida;
    private String descripcion;
    private String nombreJapo;
    private Yokai yokai;

    public int getId_detallesYokai() {
        return id_detallesYokai;
    }

    public void setId_detallesYokai(int id_detallesYokai) {
        this.id_detallesYokai = id_detallesYokai;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMedalla() {
        return medalla;
    }

    public void setMedalla(String medalla) {
        this.medalla = medalla;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreJapo() {
        return nombreJapo;
    }

    public void setNombreJapo(String nombreJapo) {
        this.nombreJapo = nombreJapo;
    }

    public Yokai getYokai() {
        return yokai;
    }

    public void setYokai(Yokai yokai) {
        this.yokai = yokai;
    }
}