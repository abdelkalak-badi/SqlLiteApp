package com.example.badi_pc.app_sqlite;

import java.io.Serializable;

public class Produits implements Serializable {
    public int ID;
    public String Produits;
    public int QProduits;

    public Produits() {
        super();
    }

    public Produits(int ID, String produits, int QProduits) {
        this.ID = ID;
        Produits = produits;
        this.QProduits = QProduits;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProduits() {
        return Produits;
    }

    public void setProduits(String produits) {
        Produits = produits;
    }

    public int getQProduits() {
        return QProduits;
    }

    public void setQProduits(int QProduits) {
        this.QProduits = QProduits;
    }


}
