package com.example.EazyBanking.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{        
        return http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/notices","/contact","/register","/swagger-ui/**","/swagger-ui.html","/swagger-resources","/v3/**").permitAll()
        .requestMatchers("/myaccount","/mybalance","/mycards","/myloans","/user").authenticated()
        .and()
        .formLogin()
        .and()
        .httpBasic().and().build();
    }

    // @Bean
    // InMemoryUserDetailsManager userDetailsService(){
    //     UserDetails admin = User.withUsername("admin").password("admin").authorities("admin").build();
    //     UserDetails user = User.withUsername("user").password("user").authorities("user").build();
    //     return new InMemoryUserDetailsManager(admin,user);
    // }

    // @Bean
    // UserDetailsService userDetailsService(DataSource dataSource){
    //     return new JdbcUserDetailsManager(dataSource);
    // }
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
