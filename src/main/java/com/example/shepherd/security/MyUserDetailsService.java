package com.example.shepherd.security;

import com.example.shepherd.models.Account;
import com.example.shepherd.repos.AccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

    private AccountRepo accountRepo;

    @Autowired
    public void setAccountRepo(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress){
        Account account = accountRepo.findByEmailAddress(emailAddress).get();
        return new MyUserDetails(account);
    }
    
}
