package com.example.backend.Dto.Response;

import com.example.backend.Model.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PostResponse {

    int id;

    String caption;

    String image;

    String video;

    LocalDateTime createdAt;

    UserResponse user;

    Set<CommentResponse> comments;

    Set<UserResponse> savedByUsers;

    Set<UserResponse> likes;

}
