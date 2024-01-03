package com.example.backend.Model;

import com.example.backend.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    String firstName;

    String lastName;

    @Column(unique = true)
    String email;

    @Column(unique = true)
    String mobileNumber;

    @Column(unique = true)
    String username;

    @Column(nullable = false )
    String password;

    String bio;

    @Enumerated(EnumType.STRING)
    Gender gender;

    String profilePicture;

    Set<Integer> followers = new HashSet<>();

    Set<Integer> followings = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Story> stories = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Reel> reels = new ArrayList<>();

    @ManyToMany(mappedBy = "likedUsers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<Post> likedPosts = new HashSet<>();

    @ManyToMany(mappedBy = "savedUsers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<Post> savedPosts = new HashSet<>();

    @OneToMany(mappedBy = "sender",cascade = CascadeType.ALL)
    List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver",cascade = CascadeType.ALL)
    List<Message> receivedMessages = new ArrayList<>();

    @ManyToMany(mappedBy = "members",cascade = CascadeType.ALL)
    Set<Chat> chat = new HashSet<>();


}

