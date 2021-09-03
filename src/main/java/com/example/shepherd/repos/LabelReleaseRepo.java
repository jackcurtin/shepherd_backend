package com.example.shepherd.repos;

import com.example.shepherd.models.LabelRelease;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelReleaseRepo extends JpaRepository<LabelRelease, Long> {
    
}
