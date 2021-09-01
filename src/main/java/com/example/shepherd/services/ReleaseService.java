package com.example.shepherd.services;

import com.example.shepherd.models.Release;
import com.example.shepherd.repos.ReleaseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {
    private ReleaseRepo releaseRepo;

    @Autowired
    private void ReleaseRepo(ReleaseRepo releaseRepo){
        this.releaseRepo = releaseRepo;
    }

    public Release createRelease(Release releaseObject){
        System.out.println("Service calling createRelease");
        if(releaseRepo.find)
    }
}
