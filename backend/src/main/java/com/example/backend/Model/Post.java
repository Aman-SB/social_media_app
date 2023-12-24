package com.example.backend.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String content;
    private String mediaType;
    private LocalDateTime timestamp;

    // Getters and setters

}

