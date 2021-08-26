package services;

import java.util.List;

import com.example.shepherd.models.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repos.AccountRepo;

@Service
public class AccountService {
    private AccountRepo accountRepo;
    @Autowired
    private void setAccountRepo(AccountRepo accountRepo){
        this. accountRepo = accountRepo;
    }

    public Account createAccount(Account accountObject){
        System.out.println("Service calling createAccount");
        return accountRepo.save(accountObject);
    }

    public List<Account> getAllAccounts(){
        System.out.println("Service calling getAllAccounts");
        return accountRepo.findAll();
    }


    

}
