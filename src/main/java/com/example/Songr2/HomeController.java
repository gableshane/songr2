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

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable String word, Model m){
        String result = word.toUpperCase();
        m.addAttribute("word",result);
        return "hello";
    }

    @GetMapping("/")
    public String home(){
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
        albumRepository.save(album1);
        albumRepository.save(album2);
        albumRepository.save(album3);

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
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

}
