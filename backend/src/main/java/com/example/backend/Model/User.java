package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "User")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(unique = true ,nullable = false )
    String email;

    @Column(unique = true ,nullable = false )
    String mobileNumber;

    @Column(unique = true ,nullable = false )
    String username;

    @Column(nullable = false )
    String password;

    String bio;

    String profilePictureURL;

}

