package com.example.EazyBanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/myaccount")
    public String getAccountDetails(){
        return "here's some details...";
    }
}
