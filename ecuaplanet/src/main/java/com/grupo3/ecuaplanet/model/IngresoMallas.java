package com.grupo3.ecuaplanet.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingreso_mallas")
public class IngresoMallas {
    @Id
    @Column(name = "id_ingreso_mallas")
    private int idIngresoMallas;
    @Column(name = "id_variedad")
    private int idVariedad;
    @Column(name = "cantidad_mallas_ingreso")
    private int cantidadMallasIngreso;
    @Column(name = "fecha_hora_ingreso")
    private LocalDateTime fechaHoraIngreso;
    @Column(name = "tallos_por_malla")
    private int tallosPorMalla;

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
