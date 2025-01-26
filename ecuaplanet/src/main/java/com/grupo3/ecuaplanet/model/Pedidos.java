package com.grupo3.ecuaplanet.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @Column(name = "id_pedido")
    private int idPedido;
    @Column(name = "id_cliente")
    private int idCliente;
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;
    @Column(name = "monto_total_venta")
    private double montoTotalVenta;

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
