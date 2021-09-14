package com.project.backend.Responses;

public class EmployeeResponse {

    private long id;
    private Double salaire;
    private UtilisateurResponse utilisateur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

//    public UtilisateurResponse getUtilisateur() {
//        return utilisateur;
//    }
//
//    public void setUtilisateur(UtilisateurResponse utilisateur) {
//        this.utilisateur = utilisateur;
//    }
}
