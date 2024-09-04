package com.appmusic.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appmusic.backend.models.Tag;
import com.appmusic.backend.repositories.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(Long id, Tag tagDetails) {
        Tag tag = tagRepository.findById(id).orElse(null);
        if (tag != null) {
            tag.setName(tagDetails.getName());
            return tagRepository.save(tag);
        }
        return null;
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
