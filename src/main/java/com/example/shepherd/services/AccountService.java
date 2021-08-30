package com.example.shepherd.services;

import java.util.List;
import java.util.Optional;

import com.example.shepherd.exceptions.InformationExistsException;
import com.example.shepherd.models.Account;
import com.example.shepherd.repos.AccountRepo;
import com.example.shepherd.security.JWTUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepo accountRepo;

    @Autowired
    private void setAccountRepo(AccountRepo accountRepo){
        this. accountRepo = accountRepo;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtils jwtUtils;

    public Account createAccount(Account accountObject){
        System.out.println("Service calling createAccount");
        Optional<Account> account = accountRepo.findByEmailAddress(accountObject.getEmailAddress());
        if(account.isPresent()){
            throw new InformationExistsException("Account already created with " + account.get().getEmailAddress());
        }
        else {
            accountObject.setPassword(passwordEncoder.encode(accountObject.getPassword()));
            return accountRepo.save(accountObject);
        }
    }

    public List<Account> getAllAccounts(){
        System.out.println("Service calling getAllAccounts");
        return accountRepo.findAll();
    }


    

}
