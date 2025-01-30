package com.grupo3.ecuaplanet.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingreso_mallas")
public class IngresoMallas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso_mallas")
    private int idIngresoMallas;

    @ManyToOne
    @JoinColumn(name = "id_variedad")
    private Variedades variedades;

    @Column(name = "cantidad_mallas_ingreso")
    private int cantidadMallas;

    @Column(name = "tallos_por_malla")
    private int tallosPorMalla;

    @Column(name = "fecha_hora_ingreso")
    private Timestamp fechaHoraIngreso;

    @Column(name="embedding",columnDefinition = "vector")
    private List<Float> embedding;

    public List<Float> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Float> embedding) {
        this.embedding = embedding;
    }

    public Timestamp getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(Timestamp fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public int getIdIngresoMallas() {
        return idIngresoMallas;
    }

    public void setIdIngresoMallas(int idIngresoMallas) {
        this.idIngresoMallas = idIngresoMallas;
    }

    public Variedades getVariedades() {
        return variedades;
    }

    public void setVariedades(Variedades variedades) {
        this.variedades = variedades;
    }

    
    public int getCantidadMallas() {
        return cantidadMallas;
    }

    public void setCantidadMallas(int cantidadMallas) {
        this.cantidadMallas = cantidadMallas;
    }

    public int getTallosPorMalla() {
        return tallosPorMalla;
    }

    public void setTallosPorMalla(int tallosPorMalla) {
        this.tallosPorMalla = tallosPorMalla;
    }
    
}
