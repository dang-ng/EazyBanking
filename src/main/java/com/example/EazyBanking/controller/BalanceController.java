package com.example.EazyBanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/mybalance")
    public String getBalanceDetails(){
        return "here's some details...";
    }
}
