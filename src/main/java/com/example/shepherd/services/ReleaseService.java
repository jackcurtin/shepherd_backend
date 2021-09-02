package com.example.shepherd.services;

import java.util.Map;
import java.util.Optional;

import com.example.shepherd.exceptions.InformationExistsException;
import com.example.shepherd.exceptions.InformationNotFoundException;
import com.example.shepherd.models.Artist;
import com.example.shepherd.models.Label;
import com.example.shepherd.models.Release;
import com.example.shepherd.repos.ArtistRepo;
import com.example.shepherd.repos.LabelRepo;
import com.example.shepherd.repos.ReleaseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseService {
    private ReleaseRepo releaseRepo;
    private ArtistRepo artistRepo;
    private LabelRepo labelRepo;

    @Autowired
    private void ReleaseRepo(ReleaseRepo releaseRepo){
        this.releaseRepo = releaseRepo;
    }

    @Autowired
    private void ArtistRepo(ArtistRepo artistRepo){
        this.artistRepo = artistRepo;
    }

    @Autowired
    private void LabelRepo(LabelRepo labelRepo){
        this.labelRepo = labelRepo;
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

    public String createLabelRelease(Map<String, String> releaseLabelPairing){
        System.out.println("Service calling createLabelRelease");
        Optional<Release> releaseOpt = releaseRepo.findById(Long.parseLong(releaseLabelPairing.get("releaseId")));
        Optional<Label> labelOpt = labelRepo.findById(Long.parseLong(releaseLabelPairing.get("labelId")));
        if(releaseOpt.isEmpty()){
            throw new InformationNotFoundException("Release not found in database");
        }
        else if (labelOpt.isEmpty()){
            throw new InformationNotFoundException("Label not found in database");
        }
        else{
            releaseOpt.get().getLabels().add(labelOpt.get());
            labelOpt.get().getReleases().add(releaseOpt.get());
            releaseRepo.save(releaseOpt.get());
            labelRepo.save(labelOpt.get());
            return releaseOpt.get().getTitle() + " on " + labelOpt.get().getName() + " has been created!";
        }
    }
}
