package com.project.backend.Responses.CmdOrders;

import com.project.backend.Responses.UtilisateurResponse;

public class CommandeAdminResponse {


    private long id;
    private UsersResponse utilisateur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsersResponse getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UsersResponse utilisateur) {
        this.utilisateur = utilisateur;
    }
}
