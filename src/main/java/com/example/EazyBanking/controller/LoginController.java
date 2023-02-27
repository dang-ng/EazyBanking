package com.example.EazyBanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EazyBanking.model.Customer;
import com.example.EazyBanking.repository.CustomerRepository;

@RestController
public class LoginController {
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("/register")
    public ResponseEntity<String> register(){
        return ResponseEntity.ok("pls register");
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try{
            savedCustomer = customerRepository.save(customer);
        if(savedCustomer.getId()>0){
            response= ResponseEntity.status(HttpStatus.CREATED).body("successfully register!");
        }
    } catch (Exception e){
        response= ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error " + e.getMessage());
    }
    return response;

}
}

