// package com.example.EazyBanking.config;

// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.IntStream;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;

// import com.example.EazyBanking.model.Customer;
// import com.example.EazyBanking.repository.CustomerRepository;

// import jakarta.annotation.PostConstruct;
// import lombok.RequiredArgsConstructor;

// @Configuration
// @RequiredArgsConstructor
// public class DemoDBConfig {
//     private final CustomerRepository customerRepository;
//     @PostConstruct
//     public void initData(){ 
//         customerRepository.saveAll(IntStream.range(0,100).mapToObj(i->Customer.builder().email("email "+i).pwd("pass " + i).role("role: "+i).build()).collect(Collectors.toList()));
//     }
// }
