package com.project.backend.Responses;


public class ProduitResponse {

    private long id;
    private String nom;
    private Double prix;
    private int quantity;
//    private String image;

    private CategorieResponse categorie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public CategorieResponse getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieResponse categorie) {
        this.categorie = categorie;
    }
}
