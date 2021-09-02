package com.example.shepherd.repos;

import java.util.Optional;

import com.example.shepherd.models.Artist;
import com.example.shepherd.models.Release;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ReleaseRepo extends JpaRepository<Release, Long>{
    Optional<Release> findByTitleAndArtist(String title, Artist artist);
}
