package com.prabhu.ganesh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello, Home!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello, Secured!";
    }

    @PreAuthorize("hasAuthority('ROLE_OFFICER1')")
    @GetMapping("/secured1")
    public String secured1() {

        return "Hello, 1!";
    }

}
