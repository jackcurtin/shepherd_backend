package com.example.shepherd.repos;

import java.util.Optional;

import com.example.shepherd.models.Artist;
import com.example.shepherd.models.Label;
import com.example.shepherd.models.LabelRelease;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelReleaseRepo extends JpaRepository<LabelRelease, Long> {
    public Optional<LabelRelease> findByTitleAndArtistAndLabel(String title, Artist artist, Label label);
}
