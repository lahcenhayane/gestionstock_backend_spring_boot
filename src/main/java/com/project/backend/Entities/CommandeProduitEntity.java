package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "commande_produit")
public class CommandeProduitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int quantute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commandes_id")
    private CommandesEntity commandes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produits_id")
    private ProduitsEntity produits;

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;


    public CommandeProduitEntity() {
        this.dateCreation = new Date();
        this.dateModification = new Date();
    }





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantute() {
        return quantute;
    }

    public void setQuantute(int quantute) {
        this.quantute = quantute;
    }

    public CommandesEntity getCommandes() {
        return commandes;
    }

    public void setCommandes(CommandesEntity commandes) {
        this.commandes = commandes;
    }

    public ProduitsEntity getProduits() {
        return produits;
    }

    public void setProduits(ProduitsEntity produits) {
        this.produits = produits;
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
