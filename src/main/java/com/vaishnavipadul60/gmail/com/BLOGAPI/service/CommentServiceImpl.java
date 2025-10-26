package com.vaishnavipadul60.gmail.com.BLOGAPI.service;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.CommentDTO;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.Comment;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.Post;
import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.User;
import com.vaishnavipadul60.gmail.com.BLOGAPI.exception.ResourceNotFoundException;
import com.vaishnavipadul60.gmail.com.BLOGAPI.repository.CommentRepository;
import com.vaishnavipadul60.gmail.com.BLOGAPI.repository.PostRepository;
import com.vaishnavipadul60.gmail.com.BLOGAPI.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    private CommentDTO mapToDto(Comment c){
        CommentDTO dto = new CommentDTO();
        dto.setId(c.getId());
        dto.setContent(c.getContent());
        dto.setPostId(c.getPost() != null ? c.getPost().getId() : null);
        dto.setAuthorId(c.getAuthor() != null ? c.getAuthor().getId() : null);
        dto.setAuthorUsername(c.getAuthor() != null ? c.getAuthor().getUsername() : null);
        return dto;
    }

    @Override
    public CommentDTO create(CommentDTO dto, String username) {
        Post post = postRepository.findById(dto.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        User author = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Comment c = new Comment();
        c.setContent(dto.getContent());
        c.setPost(post);
        c.setAuthor(author);
        Comment saved = commentRepository.save(c);
        return mapToDto(saved);
    }

    @Override
    public List<CommentDTO> getByPost(Long postId) {
        return commentRepository.findByPostId(postId).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getById(Long id) {
        return mapToDto(commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found")));
    }

    @Override
    public CommentDTO update(Long id, CommentDTO dto, String username) {
        Comment c = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        if (!c.getAuthor().getUsername().equals(username)) throw new RuntimeException("Not allowed");
        c.setContent(dto.getContent());
        return mapToDto(commentRepository.save(c));
    }

    @Override
    public void delete(Long id, String username) {
        Comment c = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment not found"));
        if (!c.getAuthor().getUsername().equals(username)) throw new RuntimeException("Not allowed");
        commentRepository.delete(c);
    }
}
