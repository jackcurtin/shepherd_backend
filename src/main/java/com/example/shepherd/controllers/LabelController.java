package com.example.shepherd.controllers;

import com.example.shepherd.services.LabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/labels")
public class LabelController {
    private LabelService labelService;

    @Autowired
    private void setLabelService(LabelService labelService){
        this.labelService = labelService;
    }

    @GetMapping
    
}
