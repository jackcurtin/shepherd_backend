package com.example.shepherd.services;

import java.util.Map;
import java.util.Optional;

import com.example.shepherd.exceptions.InformationExistsException;
import com.example.shepherd.models.Artist;
import com.example.shepherd.models.Release;
import com.example.shepherd.repos.ArtistRepo;
import com.example.shepherd.repos.ReleaseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {
    private ReleaseRepo releaseRepo;
    private ArtistRepo artistRepo;

    @Autowired
    private void ReleaseRepo(ReleaseRepo releaseRepo){
        this.releaseRepo = releaseRepo;
    }

    @Autowired
    private void ArtistRepo(ArtistRepo artistRepo){
        this.artistRepo = artistRepo;
    }

    public Release createRelease(Map <String, String> releaseObject){
        System.out.println("Service calling createRelease");
        Optional<Artist> artistOpt = artistRepo.findByName(releaseObject.get("artist"));
        Optional<Release> releaseOpt = releaseRepo.findByTitleAndArtist(releaseObject.get("title"), artistOpt.get());
        if(releaseOpt.isPresent()){
            throw new InformationExistsException(releaseOpt.get().getTitle() + " by " + releaseOpt.get().getArtist().getName() + "already in database");
        }
        else{
            Release release = new Release(releaseObject.get("title"), artistOpt.get());
            return releaseRepo.save(release);
        }
    }
}
