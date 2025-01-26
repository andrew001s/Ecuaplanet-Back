package com.grupo3.ecuaplanet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_bonches")
public class ProductosBonches {

    @Id
    @Column(name = "id_producto")
    private int idProducto;
    @Column(name = "id_variedad")
    private int idVariedad;
    @Column(name = "largo_bonche")
    private int largoBonche;
    @Column(name = "tallos_por_bonche")
    private int tallosPorBonche;
    @Column(name = "valor")
    private double valor;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(int idVariedad) {
        this.idVariedad = idVariedad;
    }

    public int getLargoBonche() {
        return largoBonche;
    }

    public void setLargoBonche(int largoBonche) {
        this.largoBonche = largoBonche;
    }

    public int getTallosPorBonche() {
        return tallosPorBonche;
    }

    public void setTallosPorBonche(int tallosPorBonche) {
        this.tallosPorBonche = tallosPorBonche;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
