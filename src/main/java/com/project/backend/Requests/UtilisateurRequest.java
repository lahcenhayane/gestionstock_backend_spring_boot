package com.project.backend.Requests;

import com.project.backend.Utils.Roles;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UtilisateurRequest {

    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String ville;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateNaissance;
    private Roles role;

    private EmployeeRequest employee;
    private ClientRequest client;
    private AdminRequest admin;


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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public EmployeeRequest getEmployee() {
        if (this.role == Roles.Employee)
            return employee;
        else
            return null;
    }

    public void setEmployee(EmployeeRequest employee) {
        if (this.role == Roles.Employee)
            this.employee = employee;
    }

    public ClientRequest getClient() {
        if (this.role == Roles.Client)
            return client;
        else
            return null;
    }

    public void setClient(ClientRequest client) {
        if (this.role == Roles.Client)
            this.client = client;
    }

    public AdminRequest getAdmin() {
        if (this.role == Roles.Admin)
            return admin;
        else
            return null;
    }

    public void setAdmin(AdminRequest admin) {
        if (this.role == Roles.Admin)
            this.admin = admin;
    }
}
