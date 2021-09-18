package com.project.backend.Responses;

import com.project.backend.Dto.UtilisateurDTO;

import java.util.Date;

public class MessageResponse {

    private long id;
    private String message;
    private String titre;
    private String email;
    private Boolean lire;
    private UtilisateurDTO utilisateur;
    private Date dateCreation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Boolean getLire() {
        return lire;
    }

    public void setLire(Boolean lire) {
        this.lire = lire;
    }

//    public UtilisateurDTO getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(UtilisateurDTO utilisateur) {
//        this.utilisateur = utilisateur;
//    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
