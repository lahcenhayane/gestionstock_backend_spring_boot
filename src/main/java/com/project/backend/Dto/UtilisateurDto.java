package com.project.backend.Dto;

import com.project.backend.Utils.Roles;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UtilisateurDto {
    private long id;
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
    private AdminDto admin;
    private ClientDto client;
    private EmployeeDto employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public AdminDto getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDto admin) {
        this.admin = admin;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }
}
