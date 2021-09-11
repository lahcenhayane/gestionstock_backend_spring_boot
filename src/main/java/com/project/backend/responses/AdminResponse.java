package com.project.backend.responses;

import com.project.backend.requests.UtilisateurRequest;

public class AdminResponse {

    private UtilisateurRequest utilisateur;

    public AdminResponse() {
    }

    public AdminResponse(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }

    public UtilisateurRequest getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }
}
