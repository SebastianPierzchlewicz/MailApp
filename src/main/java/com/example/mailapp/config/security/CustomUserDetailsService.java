package com.example.mailapp.config.security;

import com.example.mailapp.user.UserService;
import com.example.mailapp.user.dto.UserCredentialsDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(()->new UsernameNotFoundException(String.format("Uzytkownik z z mailem %s nie istenieje",username)));
    }

    private UserDetails createUserDetails(UserCredentialsDto credentials){
        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .build();
    }
}
