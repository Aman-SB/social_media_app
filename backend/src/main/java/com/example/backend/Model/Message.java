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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int messageId;

    String content;

    LocalDateTime createdAt;

    @ManyToOne
    User sender;

    @ManyToOne
    User receiver;

    @ManyToOne
    Group group;
}
