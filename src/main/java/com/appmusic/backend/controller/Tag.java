package com.appmusic.backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
