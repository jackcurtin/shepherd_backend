package com.example.shepherd.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String emailAddress;
    @Column
    private String password;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    @JsonIgnore
    private Set<Label> labels;

    @OneToMany(mappedBy = "account", orphanRemoval = true)
    @JsonIgnore
    private Set<Artist> artists;

    public Account() {
    }

    public Account(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account [emailAddress=" + emailAddress + ", id=" + id + ", password=" + password + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    
}
