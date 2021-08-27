package com.example.shepherd.services;

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

    
    
}
