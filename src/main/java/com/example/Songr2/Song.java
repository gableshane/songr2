package com.example.Songr2;


import javax.persistence.*;

@Entity
public class Song {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Album album;

    String title;
    int length;
    int trackNumber;

    public Song(){

    }

    public Song(String title, int length, int trackNumber){
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }
    public String toString(){
        return String.format("Song: %s\nLength: %d\nTrack Number: %d",
                this.title,this.length,this.trackNumber);
    }

}
