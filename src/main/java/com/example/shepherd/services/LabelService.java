package com.example.shepherd.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.shepherd.exceptions.InformationNotFoundException;
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
        System.out.println("Service calling addLabel");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountRepo.findByEmailAddress(userDetails.getUsername()).get();
        labelObject.setAccount(account);
        return labelRepo.save(labelObject);
    }

    public Label updateLabel(Long labelId, Map<String, String> labelObject){
        System.out.println("Service calling updateLabel");
        Optional<Label> labelOpt = labelRepo.findById(labelId);
        if(labelOpt.isEmpty()){
            throw new InformationNotFoundException("Label not found");
        }
        else{
            labelOpt.get().setName(labelObject.get("name"));
            labelOpt.get().setCity(labelObject.get("city"));
            return labelRepo.save(labelOpt.get());
        }
    }
    
}
