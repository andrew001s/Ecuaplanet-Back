package com.grupo3.ecuaplanet.model;

import java.time.LocalDate;

public class Pedidos {
    private int idPedido;
    private int idCliente;
    private LocalDate fechaVenta;
    private double montoTotalVenta;

    public Pedidos(int idPedido, int idCliente, LocalDate fechaVenta, double montoTotalVenta) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.montoTotalVenta = montoTotalVenta;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(double montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

}
