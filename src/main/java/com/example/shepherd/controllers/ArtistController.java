package com.example.shepherd.controllers;

import java.util.List;
import java.util.Map;

import com.example.shepherd.models.Artist;
import com.example.shepherd.services.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    private void setArtistService(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping("/all")
    public List<Artist> getAllArtists(){
        System.out.println("Controller calling getAllArtists");
        return artistService.getAllArtists();
    }

    @PostMapping("/add")
    public Artist addArtist(@RequestBody Artist artistObject){
        System.out.println("Controller calling addArtist");
        return artistService.addArtist(artistObject);
    }

    @PutMapping("/{artistId}/update")
    public Artist updateArtist(@PathVariable Long artistId, @RequestBody Map<String, String> artistObject){
        System.out.println("Controller calling updateArtist");
        return artistService.updateArtist(artistId, artistObject);
    }

    
}
