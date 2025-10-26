package com.vaishnavipadul60.gmail.com.BLOGAPI.service;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO create(PostDTO dto, String username);
    List<PostDTO> getAll();
    PostDTO getById(Long id);
    PostDTO update(Long id, PostDTO dto, String username);
    void delete(Long id, String username);
}
