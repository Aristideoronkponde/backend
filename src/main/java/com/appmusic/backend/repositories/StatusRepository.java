package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appmusic.backend.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}
