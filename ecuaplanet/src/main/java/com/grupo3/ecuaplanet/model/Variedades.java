package com.grupo3.ecuaplanet.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "variedades")
public class Variedades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variedad")
    private int idVariedad;

    @Column(name = "nombre_variedad")
    private String nombreVariedad;

    @Column(name = "color_variedad")
    private String colorVariedad;

    @Column(name = "bloque")
    private int bloque;

    @Column(name = "camas_variedad")
    private int camasVariedad;

    @OneToMany(mappedBy = "variedades")
    private List<IngresoMallas> ingresoMallas;

    @OneToMany(mappedBy = "variedades")
    private List<ProductoBonches> productoBonches;

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

    public int getBloque() {
        return bloque;
    }

    public void setBloque(int bloque) {
        this.bloque = bloque;
    }

    public int getCamasVariedad() {
        return camasVariedad;
    }

    public void setCamasVariedad(int camasVariedad) {
        this.camasVariedad = camasVariedad;
    }

    public int getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(int idVariedad) {
        this.idVariedad = idVariedad;
    }

    public List<IngresoMallas> getIngresoMallas() {
        return ingresoMallas;
    }

    public void setIngresoMallas(List<IngresoMallas> ingresoMallas) {
        this.ingresoMallas = ingresoMallas;
    }

    public List<ProductoBonches> getProductoBonches() {
        return productoBonches;
    }

    public void setProductoBonches(List<ProductoBonches> productoBonches) {
        this.productoBonches = productoBonches;
    }
    
}
