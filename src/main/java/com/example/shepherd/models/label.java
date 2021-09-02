package com.example.shepherd.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "labels")
@PrimaryKeyJoinColumn(name = "id")
public class Label extends Profile{

    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.DELETE})
    @JoinTable(
        name = "label_releases",
        joinColumns = @JoinColumn(name = "label_id"),
        inverseJoinColumns = @JoinColumn(name = "release_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Release> releases;

    public Label(String name, String city) {
        super(name, city);
    }

    public Label() {
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public void addRelease(Release release){
        this.releases.add(release);
    }
    
}
