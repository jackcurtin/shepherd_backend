package com.example.shepherd.services;

import java.util.List;

import com.example.shepherd.models.Account;
import com.example.shepherd.models.Label;
import com.example.shepherd.repos.AccountRepo;
import com.example.shepherd.repos.LabelRepo;
import com.example.shepherd.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LabelService {
    private LabelRepo labelRepo;
    private AccountRepo accountRepo;

    @Autowired
    private void setLabelRepo(LabelRepo labelRepo){
        this.labelRepo = labelRepo;
    }

    @Autowired
    private void setAccountRepo(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    public List<Label> getAllLabels(){
        System.out.println("Service calling getAllLabels");
        return labelRepo.findAll();
    }

    public Label addLabel(Label labelObject){
        System.out.println(labelObject);
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountRepo.findByEmailAddress(userDetails.getUsername()).get();
        labelObject.setAccount(account);
        return labelRepo.save(labelObject);
    }
    
}
