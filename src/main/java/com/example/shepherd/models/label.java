package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@Table(name="labels")
class label extends profile{

    public label(String name, String city) {
        super(name, city);
    }

    public label() {
    }
    
}
