package com.grupo3.ecuaplanet.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja_detalles")
public class CajaDetalles {

    @Id
    @Column(name = "id_caja_detalle")
    private int idCajaDetalle;
    @Column(name = "id_caja")
    private int idCaja;
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public int getIdCajaDetalle() {
        return idCajaDetalle;
    }

    public void setIdCajaDetalle(int idCajaDetalle) {
        this.idCajaDetalle = idCajaDetalle;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
