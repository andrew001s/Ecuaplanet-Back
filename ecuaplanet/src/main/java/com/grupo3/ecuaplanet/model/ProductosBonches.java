package com.grupo3.ecuaplanet.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos_bonches")
public class ProductosBonches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @ManyToOne
    @JoinColumn(name = "id_variedad")
    private Variedades variedades;

    @Column(name = "largo_bonche")
    private int largoBonche;

    @Column(name = "tallos_por_bonche")
    private int tallosPorBonche;

    @Column(name = "valor")
    private double valor;

   
    @OneToMany(mappedBy = "productoBonches")
    private List<ProduccionBonches> produccionBonches;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Variedades getVariedades() {
        return variedades;
    }

    public void setVariedades(Variedades variedades) {
        this.variedades = variedades;
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

    public List<ProduccionBonches> getProduccionBonches() {
        return produccionBonches;
    }

    public void setProduccionBonches(List<ProduccionBonches> produccionBonches) {
        this.produccionBonches = produccionBonches;
    }
}
