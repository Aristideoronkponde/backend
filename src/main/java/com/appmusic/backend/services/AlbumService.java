package com.appmusic.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.appmusic.backend.models.Album;
import com.appmusic.backend.repositories.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

   

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

}

