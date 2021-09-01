package com.example.shepherd.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "labels")
@PrimaryKeyJoinColumn(name = "id")
public class Label extends Profile{

    @OneToMany(mappedBy = "label")
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
