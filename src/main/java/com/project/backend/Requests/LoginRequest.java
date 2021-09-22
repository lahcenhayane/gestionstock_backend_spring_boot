package com.project.backend.Requests;

import javax.validation.constraints.*;

public class LoginRequest {

    @NotBlank(message = "Ce champ ne doit pas est vide.")
    @Email(message = "Ce champ doit respecter le format email.")
    private String email;

    @NotEmpty(message = "Ce champ ne doit pas est vide.")
    @Size(min = 8, message = "Ce champ doit avoir au mois 8 caracteres.")
    private String password;

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
}
