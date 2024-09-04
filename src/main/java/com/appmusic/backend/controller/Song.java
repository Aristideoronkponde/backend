package com.appmusic.backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String lyrics;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}

