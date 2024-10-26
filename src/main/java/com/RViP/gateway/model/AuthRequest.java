package com.RViP.gateway.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}