package com.project.backend.Responses;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CategorieResponse {

    private long id;
    private String labelle;
    private List<ProduitResponse> produits;
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

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

//    public List<ProduitResponse> getProduits() {
//        return produits;
//    }
//
//    public void setProduits(List<ProduitResponse> produits) {
//        this.produits = produits;
//    }

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
