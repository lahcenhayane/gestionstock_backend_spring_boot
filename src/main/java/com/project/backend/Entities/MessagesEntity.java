package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "messages")
public class MessagesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private String message;
    private String titre;
    private String email;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private UtilisateursEntity utilisateur;

    private Boolean lire;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;

    public MessagesEntity() {
        this.dateCreation = new Date();
        this.lire = false;
    }

    public MessagesEntity(String message, String email, String titre,UtilisateursEntity utilisateur) {
        this();
        this.message = message;
        this.email = email;
        this.titre = titre;
        this.utilisateur = utilisateur;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UtilisateursEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateursEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Boolean getLire() {
        return lire;
    }

    public void setLire(Boolean lire) {
        this.lire = lire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

}
