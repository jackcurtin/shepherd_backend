package com.example.shepherd.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@PrimaryKeyJoinColumn(name = "id")
public class Artist extends Profile{

    @OneToMany(mappedBy = "artist")
    private List<Release> releases;

    public Artist(String name, String city) {
        super(name, city);
    }

    public Artist() {
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
