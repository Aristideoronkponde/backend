package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appmusic.backend.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
