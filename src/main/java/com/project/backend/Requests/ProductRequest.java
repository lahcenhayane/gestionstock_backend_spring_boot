package com.project.backend.Requests;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ProductRequest {
    private long id;
    private String nom;
    private Double prix;
    private int quantity;
//    private String image;
    private CategorieRequest categorie;


    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

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

    public CategorieRequest getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieRequest categorie) {
        this.categorie = categorie;
    }


    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Date getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(Date supprimer) {
        this.supprimer = supprimer;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
