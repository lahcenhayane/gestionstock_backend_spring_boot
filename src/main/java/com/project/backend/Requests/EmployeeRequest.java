package com.project.backend.Requests;

import com.project.backend.Dto.UtilisateurDTO;

import javax.validation.constraints.*;

public class EmployeeRequest {

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Positive(message = "Ce champs doit etre positive.")
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
