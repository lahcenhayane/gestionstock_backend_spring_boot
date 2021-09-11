package com.project.backend.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "utilisateurs")
public class UtilisateursEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(length = 6, unique = true)
    private String cin;
    @Column(length = 15)
    private String nom;
    @Column(length = 20)
    private String prenom;
    @Column(length = 200, unique = true)
    private String email;
    @Column(length = 50)
    private String password;
    @Column(length = 30)
    private String ville;
    @Column(length = 10)
    private String tel;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date dateNaissance;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "utilisateurs")
    private Set<RolesEntity> roles = new HashSet<>();
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<MessagesEntity> messages;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private AdminsEntity admin;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private  ClientsEntity clients;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private EmployesEntity employes;

    private Boolean notification;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date supprimer;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;

    public UtilisateursEntity(){
        this.notification = true;
        this.supprimer = null;
        this.dateCreation = new Date();
        this.dateModification = null;
    }

    public UtilisateursEntity(String cin, String nom, String prenom, String email, String password, String ville, String tel, Date dateNaissance, Set<RolesEntity> roles) {
        this();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.ville = ville;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
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

    public List<MessagesEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessagesEntity> messages) {
        this.messages = messages;
    }

    public AdminsEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminsEntity admin) {
        this.admin = admin;
    }

    public ClientsEntity getClients() {
        return clients;
    }

    public void setClients(ClientsEntity clients) {
        this.clients = clients;
    }

    public EmployesEntity getEmployes() {
        return employes;
    }

    public void setEmployes(EmployesEntity employes) {
        this.employes = employes;
    }
}
