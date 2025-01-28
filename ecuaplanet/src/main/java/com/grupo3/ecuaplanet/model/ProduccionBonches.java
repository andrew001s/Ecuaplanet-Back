package com.grupo3.ecuaplanet.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produccion_bonches")
public class ProduccionBonches {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produccion_bonche")
    private int idProduccionBonche;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoBonches productoBonches;

    @Column(name = "fecha_ingreso")
    private Timestamp fechaIngreso;
    
    @Column(name = "estado_bonche")
    private String estadoBonche;

    public int getIdProduccionBonche() {
        return idProduccionBonche;
    }

    public void setIdProduccionBonche(int idProduccionBonche) {
        this.idProduccionBonche = idProduccionBonche;
    }

    public ProductoBonches getProductoBonches() {
        return productoBonches;
    }

    public void setProductoBonches(ProductoBonches productoBonches) {
        this.productoBonches = productoBonches;
    }

    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstadoBonche() {
        return estadoBonche;
    }

    public void setEstadoBonche(String estadoBonche) {
        this.estadoBonche = estadoBonche;
    }

    

}
