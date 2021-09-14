package com.project.backend.Responses;

import com.project.backend.Dto.UtilisateurDTO;

public class ClientResponse {

    private long id;
    private String adresse;
    private UtilisateurDTO utilisateur;

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
