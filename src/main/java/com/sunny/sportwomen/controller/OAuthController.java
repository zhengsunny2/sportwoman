package com.sunny.sportwomen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class OAuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
