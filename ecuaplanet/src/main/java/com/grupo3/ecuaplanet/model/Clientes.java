package com.grupo3.ecuaplanet.model;

public class Clientes {

    private int idCliente;
    private String nombreCliente;
    private String paisCliente;
    private String tipoCliente;

    public Clientes(int idCliente, String nombreCliente, String paisCliente, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.paisCliente = paisCliente;
        this.tipoCliente = tipoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPaisCliente() {
        return paisCliente;
    }

    public void setPaisCliente(String paisCliente) {
        this.paisCliente = paisCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    

}
