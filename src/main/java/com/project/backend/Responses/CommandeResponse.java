package com.project.backend.Responses;

import com.project.backend.Entities.AdminsEntity;
import com.project.backend.Entities.ClientsEntity;
import com.project.backend.Entities.EmployeesEntity;
import com.project.backend.Entities.ProduitsEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CommandeResponse {

    private long id;

    private Double prixTotal;

    private EmployeeResponse employes;

    private ClientResponse clients;

    private AdminResponse admins;

    private Set<CommandeProduitResponse> produits;

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

    public EmployeeResponse getEmployes() {
        return employes;
    }

    public void setEmployes(EmployeeResponse employes) {
        this.employes = employes;
    }

    public ClientResponse getClients() {
        return clients;
    }

    public void setClients(ClientResponse clients) {
        this.clients = clients;
    }

    public AdminResponse getAdmins() {
        return admins;
    }

    public void setAdmins(AdminResponse admins) {
        this.admins = admins;
    }

    public Set<CommandeProduitResponse> getProduits() {
        return produits;
    }

    public void setProduits(Set<CommandeProduitResponse> produits) {
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
