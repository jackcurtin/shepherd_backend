package com.example.shepherd.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.shepherd.models.Label;

public interface LabelRepo extends JpaRepository<Label, Long>{
    public Optional <Label> findByName(String name);
}
