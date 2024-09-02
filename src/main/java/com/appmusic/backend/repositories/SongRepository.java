package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appmusic.backend.models.Song;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

}
