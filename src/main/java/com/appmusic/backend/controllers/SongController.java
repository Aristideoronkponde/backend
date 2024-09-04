package com.appmusic.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import com.appmusic.backend.models.Song;
import com.appmusic.backend.services.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songService.getSongById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PutMapping("/{id}")
    @Transactional
    public Song updateSong(@PathVariable Long id, @RequestBody Song songDetails) {
        return songService.updateSong(id, songDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }
}
