package com.example.shepherd.controllers;

import java.util.Map;

import com.example.shepherd.models.LabelRelease;
import com.example.shepherd.services.LabelReleaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/labelReleases")
public class LabelReleaseController {
    private LabelReleaseService labelReleaseService;

    @Autowired
    private void LabelReleaseService(LabelReleaseService labelReleaseService){
        this.labelReleaseService = labelReleaseService;
    }

    @PostMapping("/{releaseId}/new")
    public LabelRelease createLabelRelease(@PathVariable Long releaseId, @RequestBody Map<String, String> labelReleaseObject){
        System.out.println("Controller calling createLabelRelease");
        return labelReleaseService.createLabelRelease(releaseId, labelReleaseObject);
    }
    
}
