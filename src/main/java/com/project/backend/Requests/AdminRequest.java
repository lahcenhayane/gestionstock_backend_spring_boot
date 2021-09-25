package com.project.backend.Requests;

public class AdminRequest {
    private long id;
    private UtilisateurRequest utilisateur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UtilisateurRequest getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }
}
