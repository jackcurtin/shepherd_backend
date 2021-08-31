package com.example.shepherd.models;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String city;
    
    @ManyToOne
    private Account account;

    public Profile(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Profile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
