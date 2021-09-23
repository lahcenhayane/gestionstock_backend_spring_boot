package com.project.backend.Requests;

import java.util.List;

public class CategorieRequest {

    private String labelle;
    private List<ProductRequest> produits;

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public List<ProductRequest> getProduits() {
        return produits;
    }

    public void setProduits(List<ProductRequest> produits) {
        this.produits = produits;
    }
}
