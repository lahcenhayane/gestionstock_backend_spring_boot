package com.project.backend.requests;

public class AdminRequest {

    private UtilisateurRequest utilisateur;

    public AdminRequest() {
    }

    public AdminRequest(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }

    public UtilisateurRequest getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }
}
