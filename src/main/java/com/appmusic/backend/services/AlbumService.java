package com.appmusic.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.models.Album;
import com.appmusic.backend.repositories.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    public Album createAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Long id, Album albumDetails) {
        Album album = albumRepository.findById(id).orElse(null);

        if (album != null) {
            album.setName(albumDetails.getName());
            album.setTitle(albumDetails.getTitle());
            album.setDescription(albumDetails.getDescription());
            album.setDuration(albumDetails.getDuration());
            album.setUrl(albumDetails.getUrl());
            album.setLikes(albumDetails.getLikes());
            album.setStatus(albumDetails.getStatus());
            album.setTags(albumDetails.getTags());
            album.setSongs(albumDetails.getSongs());

            return albumRepository.save(album);
            }
                return null;
        }
    
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

}
