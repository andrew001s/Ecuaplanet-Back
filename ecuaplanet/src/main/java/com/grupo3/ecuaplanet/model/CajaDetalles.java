package com.grupo3.ecuaplanet.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja_detalles")
public class CajaDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja_detalle")
    private int idCajaDetalles;

    @Column(name = "id_caja")
    private int idCaja;

    @Column(name = "id_produccion_bonche")
    private int idProduccionBonche;

    @Column(name = "fecha_registro")
    private Timestamp fechaRegistro;

    @Column(name = "embedding", columnDefinition = "vector")
    private List<Float> embedding;

    public int getIdCajaDetalles() {
        return idCajaDetalles;
    }

    public void setIdCajaDetalles(int idCajaDetalles) {
        this.idCajaDetalles = idCajaDetalles;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getIdProduccionBonche() {
        return idProduccionBonche;
    }

    public void setIdProduccionBonche(int idProduccionBonche) {
        this.idProduccionBonche = idProduccionBonche;
    }

    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<Float> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Float> embedding) {
        this.embedding = embedding;
    }

}
