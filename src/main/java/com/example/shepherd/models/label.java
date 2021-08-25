package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
class Label extends Profile{

    public Label(String name, String city) {
        super(name, city);
    }

    public Label() {
    }
    
}
