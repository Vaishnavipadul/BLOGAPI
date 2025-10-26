package com.vaishnavipadul60.gmail.com.BLOGAPI.service;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.PostDTO;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.Post;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.User;
import com.vaishnavipadul60.gmail.com.BLOGAPI.exception.ResourceNotFoundException;
import com.vaishnavipadul60.gmail.com.BLOGAPI.repository.PostRepository;
import com.vaishnavipadul60.gmail.com.BLOGAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    private PostDTO mapToDto(Post p){
        PostDTO dto = new PostDTO();
        dto.setId(p.getId());
        dto.setTitle(p.getTitle());
        dto.setContent(p.getContent());
        if (p.getAuthor() != null) {
            dto.setAuthorId(p.getAuthor().getId());
            dto.setAuthorUsername(p.getAuthor().getUsername());
        }
        return dto;
    }

    @Override
    public PostDTO create(PostDTO dto, String username) {
        User author = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Post p = new Post();
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        p.setAuthor(author);
        p.setCreatedAt(Instant.now());
        Post saved = postRepository.save(p);
        return mapToDto(saved);
    }

    @Override
    public List<PostDTO> getAll() {
        return postRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PostDTO getById(Long id) {
        Post p = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        return mapToDto(p);
    }

    @Override
    public PostDTO update(Long id, PostDTO dto, String username) {
        Post p = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (!p.getAuthor().getUsername().equals(username)) throw new RuntimeException("Not allowed");
        p.setTitle(dto.getTitle());
        p.setContent(dto.getContent());
        p.setUpdatedAt(Instant.now());
        return mapToDto(postRepository.save(p));
    }

    @Override
    public void delete(Long id, String username) {
        Post p = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        if (!p.getAuthor().getUsername().equals(username)) throw new RuntimeException("Not allowed");
        postRepository.delete(p);
    }
}
