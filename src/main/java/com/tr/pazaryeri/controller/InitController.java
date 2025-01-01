package com.tr.pazaryeri.controller;

import com.tr.pazaryeri.security.model.AccountUser;
import com.tr.pazaryeri.security.service.AccountUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InitController {

    private final AccountUserService accountUserService;

    public InitController(AccountUserService accountUserService) {
        this.accountUserService = accountUserService;
    }

}

