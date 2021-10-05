package com.project.backend.Requests;

import java.util.HashSet;
import java.util.Set;

public class CommandeRequest {

    private Double prixTotal;
    private EmployeeRequest employes;
    private ClientRequest clients;
    private AdminRequest admins;
    private Set<CommandeProduitRequest> produits = new HashSet<>();

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public EmployeeRequest getEmployes() {
        return employes;
    }

    public void setEmployes(EmployeeRequest employes) {
        this.employes = employes;
    }

    public ClientRequest getClients() {
        return clients;
    }

    public void setClients(ClientRequest clients) {
        this.clients = clients;
    }

    public AdminRequest getAdmins() {
        return admins;
    }

    public void setAdmins(AdminRequest admins) {
        this.admins = admins;
    }

    public Set<CommandeProduitRequest> getProduits() {
        return produits;
    }

    public void setProduits(Set<CommandeProduitRequest> produits) {
        this.produits = produits;
    }
}
