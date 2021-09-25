package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "employees")
public class EmployeesEntity {
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

    public EmployeesEntity() {
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public EmployeesEntity(Double salaire, UtilisateursEntity utilisateur) {
        this();
        this.salaire = salaire;
        this.utilisateur = utilisateur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
