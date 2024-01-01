package com.example.backend.Transformer;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserTransformer {
    public static UserResponse userToUserResponse(User user){
        return UserResponse.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .mobileNumber(user.getMobileNumber())
                .username(user.getUsername())
                .bio(user.getBio())
                .gender(user.getGender())
                .profilePicture(user.getProfilePicture())
                .followers(user.getFollowers())
                .followings(user.getFollowings())
                .posts(PostTransformer.listUserToUserResponse(user.getPosts()))
                .comments(CommentTransformer.listCommentToCommentResponse(user.getComments()))
                .stories(StoryTransformer.listStoryToStoryResponse(user.getStories()))
                .reels(ReelTransformer.listStoryToStoryResponse(user.getReels()))
                .savedPosts(PostTransformer.listUserToUserResponse(user.getSavedPosts()))
                .sentMessages(MessageTransformer.listMessageToMessageResponse(user.getSentMessages()))
                .receivedMessages(MessageTransformer.listMessageToMessageResponse(user.getReceivedMessages()))
                .groups(GroupTransformer.mapMessageToMessageResponse(user.getGroups()))
                .build();
    }

    public static User userRequestToUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .mobileNumber(userRequest.getMobileNumber())
                .username(userRequest.getUserName())
                .email(userRequest.getEmail())
                .gender(userRequest.getGender())
                .password(userRequest.getPassword())
                .bio(userRequest.getBio())
                .profilePicture(userRequest.getProfilePicture()).build();
    }

    public static Set<UserResponse> mapUserToUserResponse(Set<User> users){
        Set<UserResponse> userResponses = new HashSet<>();
        for(User user : users){
            userResponses.add(userToUserResponse(user));
        }
        return userResponses;
    }

    public static List<UserResponse> listUserToUserResponse(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users){
            userResponses.add(userToUserResponse(user));
        }
        return userResponses;
    }
}
