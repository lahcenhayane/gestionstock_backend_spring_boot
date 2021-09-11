package com.project.backend.requests;

import com.project.backend.entities.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class UtilisateurRequest {
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String ville;
    private String tel;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date dateNaissance;

    private List<RolesEntity> roles;
    private List<MessagesEntity> messages;
    private AdminsEntity admin;
    private ClientsEntity clients;
    private EmployesEntity employes;


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

    public List<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesEntity> roles) {
        this.roles = roles;
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
