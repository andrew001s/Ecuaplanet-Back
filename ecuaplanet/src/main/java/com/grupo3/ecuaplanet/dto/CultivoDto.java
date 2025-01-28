package com.grupo3.ecuaplanet.dto;

import java.sql.Timestamp;

public class CultivoDto {

    private String nombreVariedad;
    private String colorVariedad;
    private int bloque;
    private int camasVariedad;
    private int cantidadMallasIngreso;
    private Timestamp fechaHoraIngreso;
    private int tallosPorMalla;

    public CultivoDto(String nombreVariedad, String colorVariedad, int bloque, int camasVariedad,
            int cantidadMallasIngreso, Timestamp fechaHoraIngreso, int tallosPorMalla) {
        this.nombreVariedad = nombreVariedad;
        this.colorVariedad = colorVariedad;
        this.bloque = bloque;
        this.camasVariedad = camasVariedad;
        this.cantidadMallasIngreso = cantidadMallasIngreso;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.tallosPorMalla = tallosPorMalla;

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

    public int getCantidadMallasIngreso() {
        return cantidadMallasIngreso;
    }

    public void setCantidadMallasIngreso(int cantidadMallasIngreso) {
        this.cantidadMallasIngreso = cantidadMallasIngreso;
    }

    public Timestamp getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(Timestamp fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public int getTallosPorMalla() {
        return tallosPorMalla;
    }

    public void setTallosPorMalla(int tallosPorMalla) {
        this.tallosPorMalla = tallosPorMalla;
    }

}
