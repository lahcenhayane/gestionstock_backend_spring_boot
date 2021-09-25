package com.project.backend.Responses.CmdOrders;

import com.project.backend.Responses.UtilisateurResponse;

public class CommandeEmployeeResponse {

    private long id;
    private Double salaire;

    private UsersResponse utilisateur;

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

    public UsersResponse getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UsersResponse utilisateur) {
        this.utilisateur = utilisateur;
    }
}
