package com.project.backend.Requests;

import com.project.backend.Dto.UtilisateurDTO;

import javax.validation.constraints.*;

public class EmployeeRequest {

    private long id;
    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Positive(message = "Ce champs doit etre positive.")
    private Double salaire;
    private UtilisateurRequest utilisateur;

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

    public UtilisateurRequest getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }
}
