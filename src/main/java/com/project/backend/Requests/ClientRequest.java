package com.project.backend.Requests;

public class ClientRequest {

    private String adresse;
    private UtilisateurRequest utilisateur;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public UtilisateurRequest getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }
}
