package com.appmusic.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appmusic.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
