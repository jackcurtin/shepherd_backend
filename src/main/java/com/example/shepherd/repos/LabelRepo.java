package com.example.shepherd.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shepherd.models.Label;

public interface LabelRepo extends JpaRepository<Label, Long>{
    
}
