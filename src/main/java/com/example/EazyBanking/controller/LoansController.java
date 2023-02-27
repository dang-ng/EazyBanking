package com.example.EazyBanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("/myloans")
    public String getLoansDetails(){
        return "here's some details...";
    }
}
