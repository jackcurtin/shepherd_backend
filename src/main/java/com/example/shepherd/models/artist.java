package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@Table(name = "artists")
class artist extends profile{

    public artist(String name, String city) {
        super(name, city);
    }

    public artist() {
    }
}
