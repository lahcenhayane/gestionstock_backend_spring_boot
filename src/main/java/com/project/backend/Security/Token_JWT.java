package com.project.backend.Security;

import com.project.backend.Utils.Roles;

public class Token_JWT {

    private String token;
    private String username;
    private long user_id;
    private long id;
    private Roles role;

    public Token_JWT(String token, String username, long user_id, long id, Roles role) {
        this.token = token;
        this.username = username;
        this.user_id = user_id;
        this.id = id;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
