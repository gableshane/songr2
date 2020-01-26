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

    public Song(String title, int length, int trackNumber, Album album){
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }
    public String toString(){
        return String.format("Song: %s\nLength: %d\nTrack Number: %d",
                this.title,this.length,this.trackNumber);
    }

    public long getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
