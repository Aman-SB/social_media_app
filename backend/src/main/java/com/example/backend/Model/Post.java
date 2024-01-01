package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String caption;

    String image;

    String video;

    LocalDateTime createdAt;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "post")
    Set<Comment> comments = new HashSet<>();

    @ManyToMany(mappedBy = "savedPosts")
    Set<User> savedByUsers = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> likes = new HashSet<>();

}
