package com.grupo3.ecuaplanet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "variedades")
public class Variedades {

    @Id
    @Column(name = "id_variedad")
    private int idVariedad;
    @Column(name = "nombre_variedad")
    private String nombreVariedad;
    @Column(name = "color_variedad")
    private String colorVariedad;
    @Column(name = "bloque")
    private int bloque;
    @Column(name = "camas_variedad")
    private int camasVariedad;

    public int getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(int idVariedad) {
        this.idVariedad = idVariedad;
    }

    public String getNombreVariedad() {
        return nombreVariedad;
    }

    public void setNombreVariedad(String nombreVariedad) {
        this.nombreVariedad = nombreVariedad;
    }

    public String getColorVariedad() {
        return colorVariedad;
    }

    public void setColorVariedad(String colorVariedad) {
        this.colorVariedad = colorVariedad;
    }

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getCamasVariedad() {
        return camasVariedad;
    }

    public void setCamasVariedad(int camasVariedad) {
        this.camasVariedad = camasVariedad;
    }

}
