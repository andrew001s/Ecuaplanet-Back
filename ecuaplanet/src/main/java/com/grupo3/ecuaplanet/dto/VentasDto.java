package com.grupo3.ecuaplanet.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class VentasDto {

    private int idCajaDetalle;
    private String nombreCliente;
    private String paisCliente;
    private String tipoCliente;
    private String nombreVariedad;
    private String colorVariedad;
    private int largoBonche;
    private Date fechaVenta;
    private BigDecimal montoTotal;
    private double similarity;

    public VentasDto(int idCajaDetalle, String nombreCliente, String paisCliente, String tipoCliente,
            String nombreVariedad,
            String colorVariedad, int largoBonche, Date fechaVenta, BigDecimal montoTotal, double similarity) {
        this.idCajaDetalle = idCajaDetalle;
        this.nombreCliente = nombreCliente;
        this.paisCliente = paisCliente;
        this.tipoCliente = tipoCliente;
        this.nombreVariedad = nombreVariedad;
        this.colorVariedad = colorVariedad;
        this.largoBonche = largoBonche;
        this.fechaVenta = fechaVenta;
        this.montoTotal = montoTotal;
        this.similarity = similarity;
    }

    public int getIdCajaDetalle() {
        return idCajaDetalle;
    }

    public void setIdCajaDetalle(int idCajaDetalle) {
        this.idCajaDetalle = idCajaDetalle;
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

    public String getNombreVariedad() {
        return nombreVariedad;
    }

    public void setNombreVariedad(String nombreVariedad) {
        this.nombreVariedad = nombreVariedad;
    }

    public String getColorVariedad() {
        return colorVariedad;
    }

    public void setColorVariedad(String colorVariedad) {
        this.colorVariedad = colorVariedad;
    }

    public int getLargoBonche() {
        return largoBonche;
    }

    public void setLargoBonche(int largoBonche) {
        this.largoBonche = largoBonche;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

}
