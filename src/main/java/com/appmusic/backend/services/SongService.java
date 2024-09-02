package com.appmusic.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.models.Song;
import com.appmusic.backend.repositories.SongRepository;


@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    } 

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSong(Long id, Song songDetails) {
        Song song = songRepository.findById(id).orElse(null);

        if (song != null) {
            song.setTitle(songDetails.getTitle());
            song.setDuration(songDetails.getDuration());
            song.setLyrics(songDetails.getLyrics());
            song.setAlbum(songDetails.getAlbum());
            return songRepository.save(song);
        } 
            return null;
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
