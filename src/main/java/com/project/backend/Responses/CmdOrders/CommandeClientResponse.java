package com.project.backend.Responses.CmdOrders;

import com.project.backend.Responses.UtilisateurResponse;

public class CommandeClientResponse {

    private long id;
    private String adresse;
    private UsersResponse utilisateur;

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

    public UsersResponse getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UsersResponse utilisateur) {
        this.utilisateur = utilisateur;
    }
}
