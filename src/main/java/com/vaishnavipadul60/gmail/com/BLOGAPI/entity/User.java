package com.vaishnavipadul60.gmail.com.BLOGAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // will store encoded password

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String role = "USER";
}
