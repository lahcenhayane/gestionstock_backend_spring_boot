package com.project.backend.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.backend.Utils.Roles;
import com.project.backend.Utils.Gendre;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;
import java.util.Date;

public class UtilisateurRequest {

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Size(min = 6, message = "Ce champ doit avoir au mois 6 caracteres.")
    private String cin;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Size(min = 3, message = "Ce champ doit avoir au mois 3 caracteres.")
    private String nom;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Size(min = 3, message = "Ce champ doit avoir au mois 3 caracteres.")
    private String prenom;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Email(message = "Ce champ doit respecter le format email.")
    private String email;

    @NotEmpty(message = "Ce champ ne doit pas est vide.")
    @Size(min = 8, message = "Ce champ doit avoir au mois 8 caracteres.")
    private String password;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Size(min = 4, message = "Ce champ doit avoir au mois 4 caracteres.")
    private String ville;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Size(min = 10, message = "Ce champ doit avoir 10 caracteres.")
    @Size(max = 10, message = "Ce champ doit avoir 10 caracteres.")
    @Positive(message = "Ce champs doit etre positive.")
    private String tel;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @PastOrPresent(message = "La date naissance doit être inférieur à date aujourd'hui.")
    private Date dateNaissance;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    private Gendre gendre;

    @NotBlank(message = "Ce champ ne doit pas est vide.")
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

    public Gendre getGendre() {
        return gendre;
    }

    public void setGendre(Gendre gendre) {
        this.gendre = gendre;
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
