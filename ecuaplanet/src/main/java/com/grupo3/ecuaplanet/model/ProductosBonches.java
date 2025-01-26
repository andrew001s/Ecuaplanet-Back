package com.grupo3.ecuaplanet.model;

public class ProductosBonches {

    private int idProducto;
    private int idVariedad;
    private int largoBonche;
    private int tallosPorBonche;
    private double valor;

    public ProductosBonches(int idProducto, int idVariedad, int largoBonche, int tallosPorBonche, double valor) {
        this.idProducto = idProducto;
        this.idVariedad = idVariedad;
        this.largoBonche = largoBonche;
        this.tallosPorBonche = tallosPorBonche;
        this.valor = valor;
    }

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
