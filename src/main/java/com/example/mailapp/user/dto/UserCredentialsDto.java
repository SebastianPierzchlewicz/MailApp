package com.example.mailapp.user.dto;

public class UserCredentialsDto {
    private final String email;
    private final String password;

    public UserCredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
