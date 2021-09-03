package com.example.shepherd.services;

import java.util.Map;
import java.util.Optional;

import com.example.shepherd.exceptions.InformationExistsException;
import com.example.shepherd.exceptions.InformationNotFoundException;
import com.example.shepherd.models.Label;
import com.example.shepherd.models.LabelRelease;
import com.example.shepherd.models.Release;
import com.example.shepherd.repos.LabelReleaseRepo;
import com.example.shepherd.repos.LabelRepo;
import com.example.shepherd.repos.ReleaseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LabelReleaseService {
    private LabelReleaseRepo labelReleaseRepo;
    private ReleaseRepo releaseRepo;
    private LabelRepo labelRepo;

    @Autowired
    private void LabelReleaseRepo(LabelReleaseRepo labelReleaseRepo){
        this.labelReleaseRepo = labelReleaseRepo;
    }

    @Autowired
    private void ReleaseRepo(ReleaseRepo releaseRepo){
        this.releaseRepo = releaseRepo;
    }

    @Autowired
    private void LabelRepo(LabelRepo labelRepo){
        this.labelRepo = labelRepo;
    }
    
    public LabelRelease createLabelRelease(Long releaseId, Map<String, String> labelReleaseObject){
        System.out.println("Service calling createLabelRelease");
        Optional<Release> releaseOpt = releaseRepo.findById(releaseId);
        Optional<Label> labelOpt = labelRepo.findById(Long.parseLong(labelReleaseObject.get("labelId")));
        if(releaseOpt.isEmpty()){
            throw new InformationNotFoundException("Master release not found in database");
        }
        else if (labelOpt.isEmpty()){
            throw new InformationNotFoundException("Label not found in database");
        }
        else{
            Optional<LabelRelease> labelReleaseOpt = labelReleaseRepo.findByTitleAndArtistAndLabel(
                releaseOpt.get().getTitle(), 
                releaseOpt.get().getArtist(), 
                labelOpt.get()
                );

            if(labelReleaseOpt.isPresent()){
                throw new InformationExistsException("This exact release is already on this label");
            }
            else{
                LabelRelease labelRelease = new LabelRelease(
                releaseOpt.get().getTitle(), 
                releaseOpt.get().getArtist(), 
                labelReleaseObject.get("format"), 
                Integer.parseInt(labelReleaseObject.get("numberOfCopies")), 
                labelOpt.get()
                );
            return labelReleaseRepo.save(labelRelease);
            }
        }
    }

}
