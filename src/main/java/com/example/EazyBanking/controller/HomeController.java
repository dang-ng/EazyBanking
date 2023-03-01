package com.example.EazyBanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getHomeDetails(){
        return "here's some details...";
    }
}
