package com.example.shepherd.services;

import java.util.List;

import com.example.shepherd.models.Account;
import com.example.shepherd.models.Artist;
import com.example.shepherd.repos.AccountRepo;
import com.example.shepherd.repos.ArtistRepo;
import com.example.shepherd.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
    private ArtistRepo artistRepo;
    private AccountRepo accountRepo;

    @Autowired
    private void setArtistRepo(ArtistRepo artistRepo){
        this.artistRepo = artistRepo;
    }

    @Autowired
    private void setAccountRepo(AccountRepo accountRepo){
        this.accountRepo = accountRepo;
    }

    public List<Artist> getAllArtists(){
        System.out.println("Service calling getAllArtists");
        return artistRepo.findAll();
    }

    public Artist addArtist(Artist artistObject){
        System.out.println("Service calling addArtist");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = accountRepo.findByEmailAddress(userDetails.getUsername()).get();
        artistObject.setAccount(account);
        return artistRepo.save(artistObject);
    }
    
}
