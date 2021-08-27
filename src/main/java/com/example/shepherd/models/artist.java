package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@PrimaryKeyJoinColumn(name = "id")
public class Artist extends Profile{

    public Artist(String name, String city) {
        super(name, city);
    }

    public Artist() {
    }
}
