package com.grupo3.ecuaplanet.model;

import java.time.LocalDateTime;

public class ProduccionBonches {

    private int idProduccionBonches;
    private int idProduccion;
    private LocalDateTime fechaIngreso;
    private String estadoBonche;

    public ProduccionBonches(int idProduccionBonches, int idProduccion, LocalDateTime fechaIngreso,
            String estadoBonche) {
        this.idProduccionBonches = idProduccionBonches;
        this.idProduccion = idProduccion;
        this.fechaIngreso = fechaIngreso;
        this.estadoBonche = estadoBonche;
    }

    public int getIdProduccionBonches() {
        return idProduccionBonches;
    }

    public void setIdProduccionBonches(int idProduccionBonches) {
        this.idProduccionBonches = idProduccionBonches;
    }

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstadoBonche() {
        return estadoBonche;
    }

    public void setEstadoBonche(String estadoBonche) {
        this.estadoBonche = estadoBonche;
    }

}
