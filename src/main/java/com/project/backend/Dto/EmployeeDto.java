package com.project.backend.Dto;

import com.project.backend.Entities.UtilisateursEntity;

public class EmployeeDto {

    private long id;
    private Double salaire;
    private UtilisateursEntity utilisateur;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }


}
