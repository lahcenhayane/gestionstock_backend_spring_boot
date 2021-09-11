package com.project.backend.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "categories")
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 30)
    private String labelle;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "categories_produits",
                joinColumns = { @JoinColumn(name = "categories_id") },
                inverseJoinColumns = { @JoinColumn(name = "produits_id") }
    )
    private Set<ProduitsEntity> produits = new HashSet<>();

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public CategoriesEntity() {
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public CategoriesEntity(String labelle) {
        this();
        this.labelle = labelle;
    }


    public long getId() {
        return id;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public Set<ProduitsEntity> getProduits() {
        return produits;
    }

    public void setProduits(Set<ProduitsEntity> produits) {
        this.produits = produits;
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
