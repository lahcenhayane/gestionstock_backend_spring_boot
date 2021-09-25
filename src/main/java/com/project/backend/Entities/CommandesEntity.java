package com.project.backend.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "commandes")
public class CommandesEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Double prixTotal;

    @ManyToOne
    @JoinColumn(name = "employes_id", nullable = false)
    private EmployeesEntity employes;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private ClientsEntity clients;
    @ManyToOne
    @JoinColumn(name = "admins_id")
    private AdminsEntity admins;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "commandes_produits",
                joinColumns = { @JoinColumn(name = "commandes_id") },
                inverseJoinColumns = { @JoinColumn(name = "produits_id") }
    )
    private Set<ProduitsEntity> produits = new HashSet<>();

    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public CommandesEntity(){
        this.notification = true;
        this.supprimer = null;
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public CommandesEntity(Double prixTotal, EmployeesEntity employes, ClientsEntity clients, Set<ProduitsEntity> produits) {
        this();
        this.prixTotal = prixTotal;
        this.employes = employes;
        this.clients = clients;
        this.produits = produits;
    }

    public CommandesEntity(Double prixTotal, EmployeesEntity employes, AdminsEntity admins, Set<ProduitsEntity> produits) {
        this();
        this.prixTotal = prixTotal;
        this.employes = employes;
        this.admins = admins;
        this.produits = produits;
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

    public Set<ProduitsEntity> getProduits() {
        return produits;
    }

    public void setProduits(Set<ProduitsEntity> produits) {
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

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
