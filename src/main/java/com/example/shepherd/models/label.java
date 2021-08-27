package com.example.shepherd.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "labels")
@PrimaryKeyJoinColumn(name = "id")
public class Label extends Profile{

    @OneToMany(mappedBy = "label")
    private List<Release> releases;

    public Label(String name, String city) {
        super(name, city);
    }

    public Label() {
    }
    
}
