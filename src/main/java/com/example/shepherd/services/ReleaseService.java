package com.example.shepherd.services;

import java.util.Optional;

import com.example.shepherd.exceptions.InformationExistsException;
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
        Optional<Release> release = releaseRepo.findByTitleAndArtist(releaseObject.getTitle(), releaseObject.getArtist().getName());
        if(release.isPresent()){
            throw new InformationExistsException(release.get().getTitle() + " by " + release.get().getArtist().getName() + "already in database");
        }
        else{
            return releaseRepo.save(releaseObject);
        }
        
    }
}
