package com.vaishnavipadul60.gmail.com.BLOGAPI.repository;

import com.vaishnavipadul60.gmail.com.BLOGAPI.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> { }
