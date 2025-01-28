package com.grupo3.ecuaplanet.dto;

import java.sql.Timestamp;


public class ProduccionDto {

    private String nombreVariedad;
    private String colorVariedad;
    private int largoBonche;
    private int tallosPorBonche;
    private Timestamp fechaIngreso;
    private double valor;
    private String estadoBonche;

    public ProduccionDto(String nombreVariedad, String colorVariedad, int largoBonche, int tallosPorBonche,
            Timestamp fechaIngreso, double valor, String estadoBonche) {
        this.nombreVariedad = nombreVariedad;
        this.colorVariedad = colorVariedad;
        this.largoBonche = largoBonche;
        this.tallosPorBonche = tallosPorBonche;
        this.fechaIngreso = fechaIngreso;
        this.valor = valor;
        this.estadoBonche = estadoBonche;
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

    public int getLargoBonche() {
        return largoBonche;
    }

    public void setLargoBonche(int largoBonche) {
        this.largoBonche = largoBonche;
    }

    public int getTallosPorBonche() {
        return tallosPorBonche;
    }

    public void setTallosPorBonche(int tallosPorBonche) {
        this.tallosPorBonche = tallosPorBonche;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstadoBonche() {
        return estadoBonche;
    }

    public void setEstadoBonche(String estadoBonche) {
        this.estadoBonche = estadoBonche;
    }

}
