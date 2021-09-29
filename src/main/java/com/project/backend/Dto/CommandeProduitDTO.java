package com.project.backend.Dto;

import com.project.backend.Entities.CommandesEntity;
import com.project.backend.Entities.ProduitsEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class CommandeProduitDTO {

    private long id;
    private int quantute;
    private CommandesEntity commandes;
    private ProduitsEntity produits;
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
