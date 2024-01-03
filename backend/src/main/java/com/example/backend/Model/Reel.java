package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reelId;

    String title;

    LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    User user;

    @OneToMany(mappedBy = "reel")
    List<Story> stories = new ArrayList<>();
}
