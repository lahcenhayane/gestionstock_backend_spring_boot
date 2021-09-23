package com.project.backend.Requests;

import com.project.backend.Entities.CategoriesEntity;

import java.util.HashSet;
import java.util.Set;

public class ProductRequest {
    private String nom;
    private Double prix;
    private int quantity;
//    private String image;
    private Set<CategorieRequest> categories = new HashSet<>();

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

    public Set<CategorieRequest> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategorieRequest> categories) {
        this.categories = categories;
    }
}
