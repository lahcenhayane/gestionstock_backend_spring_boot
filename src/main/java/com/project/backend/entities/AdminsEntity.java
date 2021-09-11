package com.project.backend.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "admins")
public class AdminsEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "utilisateurs_id")
    private UtilisateursEntity utilisateur;
    @OneToMany(mappedBy = "admins", cascade = CascadeType.ALL)
    private List<CommandesEntity> commandes;

    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateCreation;
    @DateTimeFormat(pattern = "dd-mm-yyyy hh:mm:ss")
    private Date dateModification;
}
