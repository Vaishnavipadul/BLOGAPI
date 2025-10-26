package com.vaishnavipadul60.gmail.com.BLOGAPI.controller;

import com.vaishnavipadul60.gmail.com.BLOGAPI.dto.PostDTO;
import com.vaishnavipadul60.gmail.com.BLOGAPI.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService) { this.postService = postService; }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostDTO dto, Authentication auth){
        PostDTO created = postService.create(dto, auth.getName());
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> list(){
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(postService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable Long id, @RequestBody PostDTO dto, Authentication auth){
        return ResponseEntity.ok(postService.update(id, dto, auth.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id, Authentication auth){
        postService.delete(id, auth.getName());
        return ResponseEntity.noContent().build();
    }
}
