package com.appmusic.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String ref;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false, unique = true)
    private String url;

    @Column(nullable = false)
    private String likes;

    @Column(nullable = false)
    private String status;

    @ManyToMany
    @JoinTable(
        name = "album_tag",
        joinColumns = @JoinColumn(name = "album_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonManagedReference
    private List<Tag> tags;

    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Song> songs;
}
