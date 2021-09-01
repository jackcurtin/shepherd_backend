package com.example.shepherd.controllers;

import com.example.shepherd.models.Release;
import com.example.shepherd.services.ReleaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/releases")
public class ReleaseController  {
    private ReleaseService releaseService;

    @Autowired
    private void ReleaseService(ReleaseService releaseService){
        this.releaseService = releaseService;
    }

    @PostMapping("/create")
    public Release createRelease(@RequestBody Release releaseObject){
        System.out.println("Controller calling createRelease");
        return releaseService.createRelease(releaseObject);
    }

    
}
