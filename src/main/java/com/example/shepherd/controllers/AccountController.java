package com.example.shepherd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.shepherd.models.Account;
import com.example.shepherd.models.requests.LoginRequest;
import com.example.shepherd.services.AccountService;

@RestController
@RequestMapping(path = "/auth/")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public void setAccountService (AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("accounts/all")
    public List<Account> getAllAccounts(){
        System.out.println("Controller calling getAllAccounts");
        return accountService.getAllAccounts();
    }

    @PostMapping("register")
    public Account createAccount(@RequestBody Account accountObject){
        System.out.println("Controller calling createAccount");
        return accountService.createAccount(accountObject);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println("Controller calling login");
        return accountService.login(loginRequest);
    }
    
}
