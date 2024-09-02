package com.appmusic.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.repository.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongsService {

    @Autowired
    private SongRepository songRepository;

    public List<Songs> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Songs> getSongById(Long id) {
        return songRepository.findById(id);
    }

    public Songs saveSong(Songs song) {
        return songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
