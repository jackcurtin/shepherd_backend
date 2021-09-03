package com.example.shepherd.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "labels")
@PrimaryKeyJoinColumn(name = "id")
public class Label extends Profile{

    @Column
    private Boolean openToSubmissions = false;

    @OneToMany
    @JsonIgnore
    private List<LabelRelease> releases;

    public Label(String name, String city) {
        super(name, city);
    }

    public Label() {
    }

    public List<LabelRelease> getReleases() {
        return releases;
    }

    public void setReleases(List<LabelRelease> releases) {
        this.releases = releases;
    }

    public void addRelease(LabelRelease release){
        this.releases.add(release);
    }

    public Boolean getOpenToSubmissions() {
        return openToSubmissions;
    }

    public void toggleOpenToSubmissions() {
        this.openToSubmissions = !openToSubmissions;
    }
    
}
