package com.project.backend.Responses;

import com.project.backend.Entities.CategoriesEntity;

import java.util.HashSet;
import java.util.Set;

public class ProduitResponse {

    private long id;
    private String nom;
    private Double prix;
    private int quantity;
//    private String image;

    private Set<CategorieResponse> categories = new HashSet<>();

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

    public Set<CategorieResponse> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategorieResponse> categories) {
        this.categories = categories;
    }
}
