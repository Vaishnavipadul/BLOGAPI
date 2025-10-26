package com.vaishnavipadul60.gmail.com.BLOGAPI.service;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO create(CommentDTO dto, String username);
    List<CommentDTO> getByPost(Long postId);
    CommentDTO getById(Long id);
    CommentDTO update(Long id, CommentDTO dto, String username);
    void delete(Long id, String username);
}
