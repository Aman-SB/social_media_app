package com.example.backend.Model;

import jakarta.persistence.*;

@Entity
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendshipId;

    @ManyToOne
    @JoinColumn(name = "user1Id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2Id")
    private User user2;

    @Enumerated(EnumType.STRING)
    private Friendship status;

    // Getters and setters
}
