package com.appmusic.backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ref;
    private String name;
    private String title;
    private String description;
    private Integer duration;
    private String url;
    private String like;
    private String status;

    @ManyToMany
    @JoinTable(
        name = "album_tags",
        joinColumns = @JoinColumn(name = "album_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Set<Song> songs;
}

