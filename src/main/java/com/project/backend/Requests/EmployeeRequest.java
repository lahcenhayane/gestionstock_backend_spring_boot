package com.project.backend.Requests;

import com.project.backend.Dto.UtilisateurDTO;

public class EmployeeRequest {

    private Double salaire;
    private UtilisateurDTO utilisateur;

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public UtilisateurDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDTO utilisateur) {
        this.utilisateur = utilisateur;
    }
}
