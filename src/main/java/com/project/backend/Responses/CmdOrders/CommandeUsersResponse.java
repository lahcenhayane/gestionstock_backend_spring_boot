package com.project.backend.Responses.CmdOrders;

import com.project.backend.Responses.AdminResponse;
import com.project.backend.Responses.ClientResponse;
import com.project.backend.Responses.EmployeeResponse;
import com.project.backend.Responses.ProduitResponse;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CommandeUsersResponse {

    private long id;

    private Double prixTotal;

    private CommandeEmployeeResponse employes;

    private CommandeClientResponse clients;

    private CommandeAdminResponse admins;

    private Set<ProduitResponse> produits = new HashSet<>();

    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public CommandeEmployeeResponse getEmployes() {
        return employes;
    }

    public void setEmployes(CommandeEmployeeResponse employes) {
        this.employes = employes;
    }

    public CommandeClientResponse getClients() {
        return clients;
    }

    public void setClients(CommandeClientResponse clients) {
        this.clients = clients;
    }

    public CommandeAdminResponse getAdmins() {
        return admins;
    }

    public void setAdmins(CommandeAdminResponse admins) {
        this.admins = admins;
    }

    public Set<ProduitResponse> getProduits() {
        return produits;
    }

    public void setProduits(Set<ProduitResponse> produits) {
        this.produits = produits;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public Date getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(Date supprimer) {
        this.supprimer = supprimer;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
