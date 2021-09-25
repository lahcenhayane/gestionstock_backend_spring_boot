package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "clients")
public class ClientsEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(length = 250, nullable = false)
    private String adresse;

    @OneToOne
    @JoinColumn(name = "utilisateurs_id", nullable = false)
    private UtilisateursEntity utilisateur;
    @OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private List<CommandesEntity> commandes;

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public ClientsEntity() {
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public ClientsEntity(String adresse, UtilisateursEntity utilisateur) {
        this();
        this.adresse = adresse;
        this.utilisateur = utilisateur;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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
