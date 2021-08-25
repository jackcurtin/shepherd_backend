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
}
