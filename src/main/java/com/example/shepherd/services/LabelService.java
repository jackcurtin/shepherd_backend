package com.example.shepherd.services;

import java.util.List;

import com.example.shepherd.models.Label;
import com.example.shepherd.repos.LabelRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {
    private LabelRepo labelRepo;

    @Autowired
    private void setLabelRepo(LabelRepo labelRepo){
        this.labelRepo = labelRepo;
    }

    public List<Label> getAllLabels(){
        System.out.println("Service calling getAllLabels");
        return labelRepo.findAll();
    }

    public Label addLabel(Label labelObject){
        System.out.println(labelObject);
        return labelRepo.save(labelObject);
    }
    
}
