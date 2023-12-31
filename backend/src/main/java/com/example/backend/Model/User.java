package com.example.backend.Model;

import com.example.backend.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

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

    String profilePictureURL;

    List<Integer> followers = new ArrayList<>();

    List<Integer> followings = new ArrayList<>();

}

