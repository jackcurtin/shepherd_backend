package com.example.shepherd.repos;

import java.util.Optional;

import com.example.shepherd.models.Artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepo extends JpaRepository<Artist, Long> {
    public Optional<Artist> findByName(String name);
    
}
