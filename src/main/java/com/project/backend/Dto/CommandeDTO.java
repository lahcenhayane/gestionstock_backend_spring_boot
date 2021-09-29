package com.project.backend.Dto;

import com.project.backend.Entities.AdminsEntity;
import com.project.backend.Entities.ClientsEntity;
import com.project.backend.Entities.EmployeesEntity;
import com.project.backend.Entities.ProduitsEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommandeDTO {

    private long id;
    private Double prixTotal;
    private EmployeeDTO employes;
    private ClientDTO clients;
    private AdminDTO admins;
    private Set<CommandeProduitDTO> commandeProduit;
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

    public EmployeeDTO getEmployes() {
        return employes;
    }

    public void setEmployes(EmployeeDTO employes) {
        this.employes = employes;
    }

    public ClientDTO getClients() {
        return clients;
    }

    public void setClients(ClientDTO clients) {
        this.clients = clients;
    }

    public AdminDTO getAdmins() {
        return admins;
    }

    public void setAdmins(AdminDTO admins) {
        this.admins = admins;
    }

    public Set<CommandeProduitDTO> getCommandeProduit() {
        return commandeProduit;
    }

    public void setCommandeProduit(Set<CommandeProduitDTO> commandeProduit) {
        this.commandeProduit = commandeProduit;
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
