package com.example.backend.Transformer;

import com.example.backend.Dto.Response.CommentResponse;
import com.example.backend.Dto.Response.GroupResponse;
import com.example.backend.Model.Comment;
import com.example.backend.Model.Group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommentTransformer {

    public static CommentResponse commentToCommentResponse(Comment comment) {
        return CommentResponse.builder()
                .commentId(comment.getCommentId())
                .text(comment.getText())
                .createdAt(comment.getCreatedAt())
                .user(UserTransformer.userToUserResponse(comment.getUser()))
                .post(PostTransformer.postToPostResponse(comment.getPost()))
                .build();
    }

    public static Set<CommentResponse> mapCommentToCommentResponse(Set<Comment> comments){
        Set<CommentResponse> commentResponses = new HashSet<>();
        for(Comment comment : comments){
            commentResponses.add(CommentTransformer.commentToCommentResponse(comment));
        }
        return commentResponses;
    }

    public static List<CommentResponse> listCommentToCommentResponse(List<Comment> comments){
        List<CommentResponse> commentResponses = new ArrayList<>();
        for(Comment comment : comments){
            commentResponses.add(CommentTransformer.commentToCommentResponse(comment));
        }
        return commentResponses;
    }

}
