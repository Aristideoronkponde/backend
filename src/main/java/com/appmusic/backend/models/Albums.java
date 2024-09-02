package com.appmusic.backend.models;

import java.util.List;

import lombok.Data;

@Data

public class Albums {
    private Long id;
    @ManyToOne
    @JoinColumn(name="album_id ",nullable=false)
    private String album;
    private String title;
    private String ref;
    private String description;
    // private String list;
    //les relations
    @OneToMany(mappedBy="liste")
    private List<Songs> liste;


}
