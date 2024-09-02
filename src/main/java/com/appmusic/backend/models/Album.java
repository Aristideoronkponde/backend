package com.appmusic.backend.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @GeneratedValue
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

    private List<Tag> tags;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

}
