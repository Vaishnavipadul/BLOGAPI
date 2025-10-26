package com.vaishnavipadul60.gmail.com.BLOGAPI.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private Long postId;
    private Long authorId;
    private String authorUsername;
}
