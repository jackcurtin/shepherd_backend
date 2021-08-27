package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@Table(name = "labels")
@PrimaryKeyJoinColumn(name = "id")
public class Label extends Profile{

    public Label(String name, String city) {
        super(name, city);
    }

    public Label() {
    }
    
}
