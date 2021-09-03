package com.example.shepherd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table (name = "label_releases")
@PrimaryKeyJoinColumn(name = "id")
public class LabelRelease extends Release {

    @Column
    private String medium;

    @Column 
    private int numberOfCopies;

    @ManyToOne
    private Label label;
    
    public LabelRelease(String title, Artist artist, String medium, int numberOfCopies, Label label){
        super(title, artist);
        this.medium = medium;
        this.numberOfCopies = numberOfCopies;
        this.label = label;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabelRelease [title=" + this.getTitle() + "artist=" +this.getArtist().getName()
         + "label=" + label + ", medium=" + medium 
         + ", numberOfCopies=" + numberOfCopies + "]";
    }

    

}
