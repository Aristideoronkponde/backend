package com.appmusic.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.models.Album;
import com.appmusic.backend.models.Role;
import com.appmusic.backend.models.Song;
import com.appmusic.backend.models.Tag;
import com.appmusic.backend.models.User;
import com.appmusic.backend.repositories.AlbumRepository;
// import com.appmusic.backend.repositories.RoleRepository;
import com.appmusic.backend.repositories.SongRepository;
import com.appmusic.backend.repositories.TagRepository;
import com.appmusic.backend.repositories.UserRepository;
import com.github.javafaker.Faker;

// import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DatabaseSeederService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private RoleRepository roleRepository;

    private final Faker faker = new Faker();

    // @Transactional
    public void seedDatabase() {
        // Seed Roles
        // List<Role> roles = new ArrayList<>();
        // for (int i = 0; i < 5; i++) {
        //     Role role = Role.builder()
        //             .name(faker.job().position())
        //             .build();
        //     roleRepository.save(role);
        //     roles.add(role);
        // }

        // Seed Users
        // for (int i = 0; i < 10; i++) {
        //     User user = User.builder()
        //             .username(faker.name().username())
        //             .email(faker.internet().emailAddress())
        //             .password(faker.internet().password())
        //             .roles(Collections.singletonList(faker.options().nextElement(roles))) // Assign a single role
        //             .build();
        //     userRepository.save(user);
        // }

        // Seed Tags
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Tag tag = Tag.builder()
                    .name(faker.music().genre())
                    .build();
            tagRepository.save(tag);
            tags.add(tag);
        }

        // Seed Albums and Songs
        for (int i = 0; i < 5; i++) {
            List<Tag> albumTags = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                albumTags.add(faker.options().nextElement(tags)); // Assign a list of tags
            }

            Album album = Album.builder()
                    .ref(faker.code().ean13())
                    .name(faker.rockBand().name())
                    .title(faker.lorem().sentence(3))
                    .description(faker.lorem().paragraph())
                    .duration(faker.number().numberBetween(30, 120))
                    .url(faker.internet().url())
                    .likes(String.valueOf(faker.number().numberBetween(0, 1000)))
                    .status(faker.options().option("Published", "Draft"))
                    .tags(albumTags) // Pass a list of tags
                    .build();
            albumRepository.save(album);

            for (int j = 0; j < 3; j++) {
                Song song = Song.builder()
                        .title(faker.music().instrument())
                        .duration(faker.number().numberBetween(60, 300))
                        .lyrics(faker.lorem().paragraph(2))
                        .album(album)
                        .build();
                songRepository.save(song);
            }
        }
    }
}
