package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "produits")
public class ProduitsEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String nom;
    private Double prix;
    private int quantity;
    private String image;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategoriesEntity categorie;

    @OneToMany(mappedBy = "produits")
    private Set<CommandeProduitEntity> commandeProduit;

    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;


    public ProduitsEntity() {
        this.dateCreation = new Date();
        this.dateModification = new Date();
    }


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoriesEntity getCategorie() {
        return categorie;
    }

    public void setCategorie(CategoriesEntity categorie) {
        this.categorie = categorie;
    }

    public Set<CommandeProduitEntity> getCommandeProduit() {
        return commandeProduit;
    }

    public void setCommandeProduit(Set<CommandeProduitEntity> commandeProduit) {
        this.commandeProduit = commandeProduit;
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
