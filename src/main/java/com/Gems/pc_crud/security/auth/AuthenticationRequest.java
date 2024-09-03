package com.Gems.pc_crud.security.auth;

public class AuthenticationRequest {
    private String username;
    private String password;

    // Constructor vacío necesario para deserialización JSON
    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}