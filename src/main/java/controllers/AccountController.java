package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.AccountService;

import java.util.List;

import com.example.shepherd.models.Account;

@RestController
@RequestMapping(path = "/api/accounts/")
public class AccountController {
    private AccountService accountService;

    @Autowired
    private void setAccountService (AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        System.out.println("Controller calling getAllAccounts");
        return accountService.getAllAccounts();
    }

    @PostMapping("/register")
    public Account createAccount(@RequestBody Account accountObject){
        System.out.println("Controller calling createAccount");
        return accountService.createAccount(accountObject);
    }
    
}
