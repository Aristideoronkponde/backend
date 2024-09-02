package com.appmusic.backend.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@AllArgsConstructor
@Table(name="Tag")

public class Tag {
@Id
@GeneratedValue
@Column(name = "Identifiant")
private Long id;

@Column(name = "tags", nullable=false)
private String name;

// @Column(name = "création")
// private LocalDateTime createdAt;

// @Column(name = "modification")
// private LocalDateTime updatedAt;

  @ManyToMany(mappedBy = "tags")
    private List<Album> albums;
}
