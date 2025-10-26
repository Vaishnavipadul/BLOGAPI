package com.vaishnavipadul60.gmail.com.BLOGAPI.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private String authorUsername;
}
