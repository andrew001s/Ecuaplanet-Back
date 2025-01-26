package com.grupo3.ecuaplanet.model;

public class CajaDetalle {

    private int idCajaDetalle;
    private int idCaja;
    private int idProducto;
    private int fechaRegistro;

    public CajaDetalle(int idCajaDetalle, int idCaja, int idProducto, int fechaRegistro) {
        this.idCajaDetalle = idCajaDetalle;
        this.idCaja = idCaja;
        this.idProducto = idProducto;
        this.fechaRegistro = fechaRegistro;
    }

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

    public int getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(int fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

}
