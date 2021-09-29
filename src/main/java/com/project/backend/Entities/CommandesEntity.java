package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "commandes")
public class CommandesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Double prixTotal;

    @ManyToOne
    @JoinColumn(name = "employes_id")
    private EmployeesEntity employes;
    @ManyToOne
    @JoinColumn(name = "clients_id", nullable = false)
    private ClientsEntity clients;
    @ManyToOne
    @JoinColumn(name = "admins_id")
    private AdminsEntity admins;

    @OneToMany(mappedBy = "commandes")
    private Set<CommandeProduitEntity> commandeProduit;



    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;


    public CommandesEntity() {
    }

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

    public EmployeesEntity getEmployes() {
        return employes;
    }

    public void setEmployes(EmployeesEntity employes) {
        this.employes = employes;
    }

    public ClientsEntity getClients() {
        return clients;
    }

    public void setClients(ClientsEntity clients) {
        this.clients = clients;
    }

    public AdminsEntity getAdmins() {
        return admins;
    }

    public void setAdmins(AdminsEntity admins) {
        this.admins = admins;
    }

    public Set<CommandeProduitEntity> getCommandeProduit() {
        return commandeProduit;
    }

    public void setCommandeProduit(Set<CommandeProduitEntity> commandeProduit) {
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
