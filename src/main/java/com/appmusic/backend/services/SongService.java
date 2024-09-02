package com.appmusic.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.models.Song;
import com.appmusic.backend.repositories.SongRepository;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long id) {
        return songRepository.findById(id);
    }
    public Song createSong(Song song) {
        return songRepository.save(song);
    }
    



    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
