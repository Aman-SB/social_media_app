package com.example.backend.Transformer;

import com.example.backend.Dto.Request.PostRequest;
import com.example.backend.Dto.Response.PostResponse;
import com.example.backend.Model.Post;

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
                .user(UserTransformer.userToUserResponse(post.getUser()))
                .comments(CommentTransformer.mapCommentToCommentResponse(post.getComments()))
                .savedByUsers(UserTransformer.mapUserToUserResponse(post.getSavedUsers()))
                .likes(UserTransformer.mapUserToUserResponse(post.getLikedUsers()))
                .build();
    }

    public static Post postRequestToPost(PostRequest postRequest){
        return Post.builder()
                .caption(postRequest.getCaption())
                .image(postRequest.getImage())
                .video(postRequest.getVideo())
                .build();
    }

    public static List<PostResponse> listUserToUserResponse(List<Post> posts){
        if(posts == null)return null;
        List<PostResponse> userResponses = new ArrayList<>();
        for(Post post : posts){
            userResponses.add(postToPostResponse(post));
        }
        return userResponses;
    }

    public static Set<PostResponse> mapUserToUserResponse(Set<Post> posts){
        if(posts == null)return null;
        Set<PostResponse> userResponses = new HashSet<>();
        for(Post post : posts){
            userResponses.add(postToPostResponse(post));
        }
        return userResponses;
    }

}
