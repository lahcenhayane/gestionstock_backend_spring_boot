package com.project.backend.Responses;

import com.project.backend.Entities.CommandesEntity;
import com.project.backend.Entities.ProduitsEntity;

public class CommandeProduitResponse {

    private long id;
    private int quantute;
    private CommandesEntity commandes;
    private ProduitsEntity produits;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantute() {
        return quantute;
    }

    public void setQuantute(int quantute) {
        this.quantute = quantute;
    }

    public CommandesEntity getCommandes() {
        return commandes;
    }

    public void setCommandes(CommandesEntity commandes) {
        this.commandes = commandes;
    }

    public ProduitsEntity getProduits() {
        return produits;
    }

    public void setProduits(ProduitsEntity produits) {
        this.produits = produits;
    }
}
