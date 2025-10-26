package com.vaishnavipadul60.gmail.com.BLOGAPI.controller;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.CommentDTO;
import com.vaishnavipadul60.gmail.com.BLOGAPI.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) { this.commentService = commentService; }

    @PostMapping
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO dto, Authentication auth){
        return ResponseEntity.status(201).body(commentService.create(dto, auth.getName()));
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> listByPost(@RequestParam Long postId){
        return ResponseEntity.ok(commentService.getByPost(postId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> update(@PathVariable Long id, @RequestBody CommentDTO dto, Authentication auth){
        return ResponseEntity.ok(commentService.update(id, dto, auth.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, Authentication auth){
        commentService.delete(id, auth.getName());
        return ResponseEntity.noContent().build();
    }
}
