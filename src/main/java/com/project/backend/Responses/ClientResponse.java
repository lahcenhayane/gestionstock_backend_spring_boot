package com.project.backend.Responses;

import com.project.backend.Dto.UtilisateurDTO;

public class ClientResponse {

    private long id;
    private String adresse;
    private UtilisateurResponse utilisateur;

//    public UtilisateurResponse getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(UtilisateurResponse utilisateur) {
//        this.utilisateur = utilisateur;
//    }

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
}
