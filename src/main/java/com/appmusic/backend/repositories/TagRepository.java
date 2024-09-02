package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appmusic.backend.models.Tag;


public interface TagRepository extends JpaRepository<Tag,Long> {

}
