package com.project.backend.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "employes")
public class EmployesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private Double salaire;

    @OneToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateursEntity utilisateur;
    @OneToMany(mappedBy = "employes", cascade = CascadeType.ALL)
    private List<CommandesEntity> commandes;

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public EmployesEntity() {
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public EmployesEntity(Double salaire, UtilisateursEntity utilisateur) {
        this();
        this.salaire = salaire;
        this.utilisateur = utilisateur;
    }

    public long getId() {
        return id;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public UtilisateursEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateursEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<CommandesEntity> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandesEntity> commandes) {
        this.commandes = commandes;
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
