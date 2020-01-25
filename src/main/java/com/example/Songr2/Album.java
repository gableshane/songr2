package com.example.Songr2;

import javax.persistence.*;
import java.util.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(mappedBy = "album")
    public List<Song> songs;

    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;

    public Album(String title, String artist, int songCount, int length, String imageUrl){

        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album(){

    }
    public String toString(){
        return String.format(
                "Album name: %s\nArtist: %s\n" +
                        "Tracks: %d\nLength(seconds): %d\nImage URL: %s",
                this.title,this.artist,this.songCount,this.length,this.imageUrl);
    }


    public long getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}