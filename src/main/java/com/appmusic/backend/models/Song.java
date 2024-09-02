package com.appmusic.backend.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

// @Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String lyrics;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Albums album;
}


