package com.grupo3.ecuaplanet.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produccion_bonches")
public class ProduccionBonches {

    @Id
    @Column(name = "id_produccion_bonche")
    private int idProduccionBonches;
    @Column(name = "id_produccion")
    private int idProduccion;
    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;
    @Column(name = "estado_bonche")
    private String estadoBonche;

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
