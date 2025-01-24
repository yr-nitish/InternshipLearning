package com.effigo_global_springboot.todowebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("nitish");
        boolean isValidPassword = password.equals("nitish123");

        return (isValidUserName && isValidPassword);
    }
}

