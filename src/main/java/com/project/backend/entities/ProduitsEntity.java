package com.project.backend.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "produits")
public class ProduitsEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String nom;
    private Double prix;
    private int quantity;
    private String image;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "produits")
    private List<CategoriesEntity> categories;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "produits")
    private List<CommandesEntity> commandes;

    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public ProduitsEntity() {
        this.notification = true;
        this.supprimer = null;
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public ProduitsEntity(String nom, Double prix, int quantity, String image, List<CategoriesEntity> categories) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.quantity = quantity;
        this.image = image;
        this.categories = categories;
    }

    public long getId() {
        return id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public List<CommandesEntity> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandesEntity> commandes) {
        this.commandes = commandes;
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

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
