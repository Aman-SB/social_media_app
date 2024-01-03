package com.example.backend.Transformer;

import com.example.backend.Dto.Request.PostRequest;
import com.example.backend.Dto.Response.PostResponse;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Model.Post;
import com.example.backend.Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PostTransformer {

    public static PostResponse postToPostResponse(Post post){
        if(post == null)return null;
        return PostResponse.builder().id(post.getId())
                .caption(post.getCaption())
                .image(post.getImage())
                .video(post.getVideo())
                .createdAt(post.getCreatedAt())
                .user(UserTransformer.userToUserResponseWithoutPosts(post.getUser()))
                .comments(CommentTransformer.mapCommentToCommentResponse(post.getComments()))
                .savedByUsers(UserTransformer.mapUserToUserResponse(post.getSavedUsers()))
                .likes(UserTransformer.mapUserToUserResponse(post.getLikedUsers()))
                .build();
    }

    public static PostResponse postToPostResponseWithoutUser(Post post) {
        if (post == null) return null;
        return PostResponse.builder()
                .id(post.getId())
                .caption(post.getCaption())
                .image(post.getImage())
                .video(post.getVideo())
                .createdAt(post.getCreatedAt())
                .comments(CommentTransformer.mapCommentToCommentResponse(post.getComments()))
                .savedByUsers(mapUserToUserResponseWithoutPost(post.getSavedUsers()))
                .likes(mapUserToUserResponseWithoutPost(post.getLikedUsers()))
                .build();
    }

    private static Set<UserResponse> mapUserToUserResponseWithoutPost(Set<User> users) {
        if (users == null) return new HashSet<>();
        Set<UserResponse> userResponses = new HashSet<>();
        for (User user : users) {
            userResponses.add(UserResponse.builder()
                    .userId(user.getUserId())
                    .username(user.getUsername())
                    .profilePicture(user.getProfilePicture())
                    // Exclude posts to avoid circular reference
                    .build());
        }
        return userResponses;
    }

    public static Post postRequestToPost(PostRequest postRequest){
        if(postRequest == null)return null;
        return Post.builder()
                .caption(postRequest.getCaption())
                .image(postRequest.getImage())
                .video(postRequest.getVideo())
                .build();
    }

    public static List<PostResponse> listPostToPostResponse(List<Post> posts){
        if(posts == null)return new ArrayList<>();
        List<PostResponse> postResponses = new ArrayList<>();
        for(Post post : posts){
            postResponses.add(postToPostResponse(post));
        }
        return postResponses;
    }

    public static Set<PostResponse> mapPostToPostResponse(Set<Post> posts){
        if(posts == null)return new HashSet<>();
        Set<PostResponse> postResponses = new HashSet<>();
        for(Post post : posts){
            postResponses.add(postToPostResponse(post));
        }
        return postResponses;
    }

}
