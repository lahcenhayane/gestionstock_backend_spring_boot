package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "admins")
public class AdminsEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateurs_id")
    private UtilisateursEntity utilisateur;
    @OneToMany(mappedBy = "admins", cascade = CascadeType.ALL)
    private List<CommandesEntity> commandes;

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;


    public AdminsEntity() {
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public AdminsEntity(UtilisateursEntity utilisateur) {
        this();
        this.utilisateur = utilisateur;
    }

    public AdminsEntity(List<CommandesEntity> commandes) {
        this();
        this.commandes = commandes;
    }

    public long getId() {
        return id;
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
