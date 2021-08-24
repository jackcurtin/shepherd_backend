package com.example.shepherd.models;

import javax.persistence.*;

public abstract class profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String city;

    public profile(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public profile() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "label [city=" + city + ", id=" + id + ", name=" + name + "]";
    }
}
