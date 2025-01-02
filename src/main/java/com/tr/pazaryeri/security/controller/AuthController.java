package com.tr.pazaryeri.security.controller;

import com.tr.pazaryeri.security.model.AccountUser;
import com.tr.pazaryeri.security.service.AccountUserService;
import com.tr.pazaryeri.security.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AccountUserService accountUserService;
    private final AuthenticationService authenticationService;

    public AuthController( AuthenticationService authenticationService, AccountUserService accountUserService) {
        this.authenticationService = authenticationService;
        this.accountUserService = accountUserService;
    }

    // http://localhost:8080/auth/init
    @GetMapping("/init")
    public String init() {

        AccountUser accountUser = accountUserService.registerUser("super", "123456", "Süper Admin", "Admin");
        return "ok";
    }

}


