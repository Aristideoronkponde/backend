package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appmusic.backend.models.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    
}
