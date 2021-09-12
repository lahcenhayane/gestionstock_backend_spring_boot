package com.project.backend.Dto;

import com.project.backend.Entities.UtilisateursEntity;

public class ClientDto {
    private long id;
    private String adresse;
    private UtilisateursEntity utilisateur;

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

//    public UtilisateursEntity getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(UtilisateursEntity utilisateur) {
//        this.utilisateur = utilisateur;
//    }
}
