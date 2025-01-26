package com.grupo3.ecuaplanet.model;

import java.time.LocalDateTime;

public class IngresoMallas {
    private int idIngresoMallas;
    private int idVariedad;
    private int cantidadMallasIngreso;
    private LocalDateTime fechaHoraIngreso;
    private int tallosPorMalla;

    public IngresoMallas(int idIngresoMallas, int idVariedad, int cantidadMallasIngreso, LocalDateTime fechaHoraIngreso,
            int tallosPorMalla) {
        this.idIngresoMallas = idIngresoMallas;
        this.idVariedad = idVariedad;
        this.cantidadMallasIngreso = cantidadMallasIngreso;
        this.fechaHoraIngreso = fechaHoraIngreso;
        this.tallosPorMalla = tallosPorMalla;
    }

    public int getIdIngresoMallas() {
        return idIngresoMallas;
    }

    public void setIdIngresoMallas(int idIngresoMallas) {
        this.idIngresoMallas = idIngresoMallas;
    }

    public int getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(int idVariedad) {
        this.idVariedad = idVariedad;
    }

    public int getCantidadMallasIngreso() {
        return cantidadMallasIngreso;
    }

    public void setCantidadMallasIngreso(int cantidadMallasIngreso) {
        this.cantidadMallasIngreso = cantidadMallasIngreso;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public int getTallosPorMalla() {
        return tallosPorMalla;
    }

    public void setTallosPorMalla(int tallosPorMalla) {
        this.tallosPorMalla = tallosPorMalla;
    }

}
