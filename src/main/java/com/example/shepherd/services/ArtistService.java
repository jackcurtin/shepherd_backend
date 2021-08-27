package com.example.shepherd.services;

import java.util.List;

import com.example.shepherd.models.Artist;
import com.example.shepherd.repos.ArtistRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private ArtistRepo artistRepo;

    @Autowired
    private void setArtistRepo(ArtistRepo artistRepo){
        this.artistRepo = artistRepo;
    }

    public List<Artist> getAllArtists(){
        System.out.println("Service calling getAllArtists");
        return artistRepo.findAll();
    }

    public Artist addArtist(Artist artistObject){
        System.out.println("Service calling addArtist");
        return artistRepo.save(artistObject);
    }
    
}
