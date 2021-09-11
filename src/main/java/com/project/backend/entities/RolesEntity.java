package com.project.backend.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String libelle;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "utilisateurs_roles",
            joinColumns ={@JoinColumn(name = "roles_id")},
            inverseJoinColumns = {@JoinColumn(name = "utilisateurs_id")}
    )
    private Set<UtilisateursEntity> utilisateurs = new HashSet<>();

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public RolesEntity() {
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public RolesEntity(String libelle) {
        this();
        this.libelle = libelle;
    }

    public RolesEntity(String libelle, Set<UtilisateursEntity> utilisateurs) {
        this();
        this.libelle = libelle;
        this.utilisateurs = utilisateurs;
    }

    public long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<UtilisateursEntity> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<UtilisateursEntity> utilisateurs) {
        this.utilisateurs = utilisateurs;
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
