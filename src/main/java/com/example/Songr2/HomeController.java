package com.example.Songr2;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.*;

import java.util.*;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable String word, Model m) {
        String result = word.toUpperCase();
        m.addAttribute("word", result);
        return "hello";
    }

    @GetMapping("/")
    public String home() {
        Album album1 = new Album(
                "Look What the Cat Dragged In",
                "Poison",
                10,
                2004,
                "1.jpg");
        Album album2 = new Album("Open Up and Say... Ahh!",
                "Poison",
                10,
                2171,
                "2.png");
        Album album3 = new Album("Flesh and Blood",
                "Poison",
                14,
                3458,
                "3.jpg");
        albumRepository.saveAndFlush(album1);
        albumRepository.saveAndFlush(album2);
        albumRepository.saveAndFlush(album3);
        return "home";
    }


    @GetMapping("/albums")
    public String albums(Model m){
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums",albums);

        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView postAlbum(String title, String artist, int songCount, int length, String url){
        Album album = new Album(title,artist,songCount,length,url);
        albumRepository.saveAndFlush(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/songs")
    public String songs(Model m){
        List<Song> songs = songRepository.findAll();
        m.addAttribute("songs",songs);
        return "songs";
    }

    @PostMapping("/songs")
    public RedirectView postSong(String title, int trackNumber, int length){
        Song song = new Song(title,trackNumber,length);
        songRepository.save(song);
        return new RedirectView("/songs");
    }

    @GetMapping("/albums/{id}")
    public String getAlbumDetail(@PathVariable long id, Model m){
        Optional<Album> album = albumRepository.findById(id);
        m.addAttribute("album",album);
            return "albumdetail";
        }
    }
