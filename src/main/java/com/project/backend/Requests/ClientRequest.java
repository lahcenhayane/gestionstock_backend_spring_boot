package com.project.backend.Requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientRequest {

    private long id;
    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Size(min = 8, message = "Ce champ doit avoir au mois 8 caracteres.")
    private String adresse;
    private UtilisateurRequest utilisateur;

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

    public UtilisateurRequest getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurRequest utilisateur) {
        this.utilisateur = utilisateur;
    }
}
