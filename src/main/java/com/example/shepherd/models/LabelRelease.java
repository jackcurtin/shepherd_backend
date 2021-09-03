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
    private String format;

    @Column 
    private int numberOfCopies;

    @ManyToOne
    private Label label;
    
    public LabelRelease(String title, Artist artist, String format, int numberOfCopies, Label label){
        super(title, artist);
        this.format = format;
        this.numberOfCopies = numberOfCopies;
        this.label = label;
    }

    public LabelRelease(){
        
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
         + "label=" + label + ", format=" + format 
         + ", numberOfCopies=" + numberOfCopies + "]";
    }

    

}
