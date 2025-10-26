package com.vaishnavipadul60.gmail.com.BLOGAPI.repository;

import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
