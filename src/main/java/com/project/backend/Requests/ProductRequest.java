package com.project.backend.Requests;


public class ProductRequest {
    private String nom;
    private Double prix;
    private int quantity;
//    private String image;
    private CategorieRequest categorie;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategorieRequest getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieRequest categorie) {
        this.categorie = categorie;
    }
}
