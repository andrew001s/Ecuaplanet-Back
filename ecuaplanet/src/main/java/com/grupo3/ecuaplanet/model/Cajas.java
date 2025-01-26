package com.grupo3.ecuaplanet.model;

public class Cajas {
    private int idCaja;
    private int idPedido;

    public Cajas(int idCaja, int idPedido) {
        this.idCaja = idCaja;
        this.idPedido = idPedido;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    

}
