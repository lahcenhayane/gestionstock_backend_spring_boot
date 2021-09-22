package com.project.backend.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.backend.Utils.Roles;
import com.project.backend.Utils.Sexe;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "utilisateurs")
public class UtilisateursEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @Column(length = 10, unique = true)
    private String cin;
    @Column(length = 15)
    private String nom;
    @Column(length = 20)
    private String prenom;
    @Column(length = 200, unique = true)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(length = 30)
    private String ville;
    @Column(length = 10)
    private String tel;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Enumerated(EnumType.STRING)
    private Roles role;


    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<MessagesEntity> messages;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private AdminsEntity admin;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private  ClientsEntity client;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private EmployeesEntity employee;

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

    public UtilisateursEntity(String cin, String nom, String prenom, String email, String password, String ville, String tel, Date dateNaissance, Sexe sexe, Roles role) {
        this();
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.ville = ville;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.role = role;

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

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
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

    public ClientsEntity getClient() {
        return client;
    }

    public void setClient(ClientsEntity client) {
        this.client = client;
    }

    public EmployeesEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeesEntity employee) {
        this.employee = employee;
    }
}
