package com.example.backend.Transformer;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.PostResponse;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Model.Post;
import com.example.backend.Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserTransformer {
    public static UserResponse userToUserResponse(User user){
        if (user == null) return null;
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
                .posts(PostTransformer.listPostToPostResponse(user.getPosts()))
                .comments(CommentTransformer.listCommentToCommentResponse(user.getComments()))
                .stories(StoryTransformer.listStoryToStoryResponse(user.getStories()))
                .reels(ReelTransformer.listReelToReelResponse(user.getReels()))
                .savedPosts(mapSavedPostsToPostResponse(user.getSavedPosts()))
                .likedPost(mapLikedPostsToPostResponse(user.getLikedPosts()))
                .sentMessages(MessageTransformer.listMessageToMessageResponse(user.getSentMessages()))
                .receivedMessages(MessageTransformer.listMessageToMessageResponse(user.getReceivedMessages()))
                .chats(ChatTransformer.mapChatToChatResponse(user.getChat()))
                .build();
    }

    public static UserResponse userToUserResponseWithoutPosts(User user) {
        if (user == null) return null;
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
                .savedPosts(mapSavedPostsToPostResponse(user.getSavedPosts()))
                .sentMessages(MessageTransformer.listMessageToMessageResponse(user.getSentMessages()))
                .receivedMessages(MessageTransformer.listMessageToMessageResponse(user.getReceivedMessages()))
                .chats(ChatTransformer.mapChatToChatResponse(user.getChat()))
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

    private static Set<Integer> mapUsersToUserIds(Set<User> users) {
        if (users == null) return new HashSet<>();
        Set<Integer> userIds = new HashSet<>();
        for (User user : users) {
            userIds.add(user.getUserId());
        }
        return userIds;
    }

    public static Set<UserResponse> mapUserToUserResponse(Set<User> users){
        if(users == null)return new HashSet<>();
        Set<UserResponse> userResponses = new HashSet<>();
        for(User user : users){
            userResponses.add(userToUserResponse(user));
        }
        return userResponses;
    }

    public static Set<PostResponse> mapLikedPostsToPostResponse(Set<Post> likedPosts) {
        if (likedPosts == null) return new HashSet<>();
        Set<PostResponse> postResponses = new HashSet<>();
        for (Post post : likedPosts) {
            postResponses.add(PostTransformer.postToPostResponseWithoutUser(post));
        }
        return postResponses;
    }

    public static Set<PostResponse> mapSavedPostsToPostResponse(Set<Post> savedPosts) {
        if (savedPosts == null) return new HashSet<>();
        Set<PostResponse> postResponses = new HashSet<>();
        for (Post post : savedPosts) {
            postResponses.add(PostTransformer.postToPostResponseWithoutUser(post));
        }
        return postResponses;
    }

    public static List<UserResponse> listUserToUserResponse(List<User> users){
        if(users == null)return new ArrayList<>();
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users){
            userResponses.add(userToUserResponse(user));
        }
        return userResponses;
    }
}
