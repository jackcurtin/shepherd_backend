package com.example.shepherd.controllers;

import java.util.List;
import java.util.Map;

import com.example.shepherd.models.Label;
import com.example.shepherd.services.LabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/all")
    public List<Label> getAllLabels(){
        System.out.println("Controller calling getAllLabels");
        return labelService.getAllLabels();
    }

    @PostMapping("/add")
    public Label addLabel(@RequestBody Label labelObject){
        System.out.println("Controller calling addLabel");
        return labelService.addLabel(labelObject);
    }

    @PutMapping("/{labelId}/update")
    public Label updateLabel(@PathVariable Long labelId, @RequestBody Map<String, String> labelObject){
        System.out.println("Controller calling updateLabel");
        return labelService.updateLabel(labelId, labelObject);
    }

    @PutMapping("/{labelId}/toggleSub")
    public String toggleSubmissions(@PathVariable long labelId){
        System.out.println("Controller calling toggleSubmissions");
        return labelService.toggleSubmissions(labelId);
    }

}
