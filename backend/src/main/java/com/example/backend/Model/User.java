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

    List<Integer> followers = new ArrayList<>();

    List<Integer> followings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Story> stories = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Reel> reels = new ArrayList<>();

    @ManyToMany(mappedBy = "savedByUsers")
    List<Post> savedPosts = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    List<Message> receivedMessages = new ArrayList<>();

    @ManyToMany(mappedBy = "members")
    Set<Group> groups = new HashSet<>();


}

