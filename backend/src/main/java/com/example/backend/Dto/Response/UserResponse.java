package com.example.backend.Dto.Response;

import com.example.backend.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class UserResponse {

    int userId;

    String firstName;

    String lastName;

    String email;

    String mobileNumber;

    String username;

    String bio;

    Gender gender;

    String profilePicture;

    List<Integer> followers;

    List<Integer> followings;

    List<PostResponse> posts;

    List<CommentResponse> comments;

    List<StoryResponse> stories;

    List<ReelResponse> reels;

    List<PostResponse> savedPosts;

    List<MessageResponse> sentMessages;

    List<MessageResponse> receivedMessages;

    Set<GroupResponse> groups;
}
