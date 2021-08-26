package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.shepherd.models.Account;

@RestController
@RequestMapping(path = "/api/accounts/")
public class AccountController {

    @GetMapping
    public List<Account> getAllAccounts(){
        System.out.println("Controller calling getAllAccounts");
        
    }
    
}
