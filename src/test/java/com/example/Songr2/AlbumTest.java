package com.example.Songr2;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    Album albert;

    @Before
    public void createTestAlbum(){
        albert = new Album("Test","TestArtist",99,11,"test.com");
    }

    @Test
    void getTitle() {
        System.out.println(albert);
        assertEquals("Test",albert.getTitle());
    }

    @Test
    void getArtist() {
        assertEquals("TestArtist",albert.getArtist());
    }

    @Test
    void getSongCount() {
        assertEquals(99,albert.getSongCount());
    }

    @Test
    void getLength() {
        assertEquals(11,albert.getSongCount());
    }

    @Test
    void getImageUrl() {
        assertEquals("test.com",albert.getImageUrl());
    }

    @Test
    void setTitle() {
        albert.setTitle("newTitle");
        assertEquals("newTitle",albert.getTitle());
    }

    @Test
    void setArtist() {
        albert.setArtist("newArtist");
        assertEquals("newArtist",albert.getArtist());
    }

    @Test
    void setSongCount() {
        albert.setSongCount(72);
        assertEquals(72,albert.getSongCount());
    }

    @Test
    void setLength() {
        albert.setLength(1);
        assertEquals(1,albert.getLength());
    }

    @Test
    void setImageUrl() {
        albert.setImageUrl("newURL.com");
        assertEquals("newURL.com",albert.getImageUrl());
    }
}