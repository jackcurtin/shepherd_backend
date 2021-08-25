package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
class Artist extends Profile{

    public Artist(String name, String city) {
        super(name, city);
    }

    public Artist() {
    }
}
