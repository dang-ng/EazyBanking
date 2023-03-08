package com.example.EazyBanking.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.EazyBanking.model.Authority;
import com.example.EazyBanking.model.Customer;
import com.example.EazyBanking.repository.CustomerRepository;

@Component
public class EazingBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<Customer> customers = customerRepository.findByEmail(username);
        if(!customers.isEmpty()){
            if (passwordEncoder.matches(password, customers.get(0).getPwd())) {
                Set<Authority> authorities = customers.get(0).getAuthorities();
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                for (Authority authority : authorities){
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
                }
                return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
            } else throw new BadCredentialsException("Invalid password");
        } else throw new BadCredentialsException("no user found");
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
