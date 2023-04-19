package com.example.mailapp.user.dto;

import com.example.mailapp.user.User;

public class UserCredentialsDtoMapper {
    public static UserCredentialsDto map(User user){
        String emial = user.getEmail();
        String password = user.getPassword();
        return new UserCredentialsDto(emial, password);
    }
}
