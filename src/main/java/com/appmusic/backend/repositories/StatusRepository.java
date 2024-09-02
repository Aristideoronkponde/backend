package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appmusic.backend.models.Status;


interface StatusRepository extends JpaRepository<Status,Long> {

}
