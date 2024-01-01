package com.example.backend.Service;

import com.example.backend.Dto.Request.PostRequest;
import com.example.backend.Dto.Response.PostResponse;
import com.example.backend.Exception.PostIsNotValidException;
import com.example.backend.Model.Post;
import com.example.backend.Model.User;
import com.example.backend.Repository.PostRepository;
import com.example.backend.Transformer.PostTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;

    public Post findPostById(int postId){
        Optional<Post> optionalPost = postRepository.findById(postId);

        if(!optionalPost.isPresent()){
            throw new PostIsNotValidException("Post is not Valid with this " + postId);
        }

        return optionalPost.get();
    }

    public PostResponse createPost(PostRequest postRequest, int usedId) {
        User user =  userService.findUserById(usedId);

         Post post = PostTransformer.postRequestToPost(postRequest);
         post.setCreatedAt(LocalDateTime.now());
         post.setUser(user);

         Post savedPost = postRepository.save(post);

         return PostTransformer.postToPostResponse(savedPost);
    }


    public PostResponse findPostByPostId(int postId) {
        Post post = findPostById(postId);
        return PostTransformer.postToPostResponse(post);
    }

    public String deletePost(int postId, int userId) {
    }

    public List<Post> findAllPost(int userId) {
    }

    public PostResponse savePost(int postId, int userId) {
    }

    public PostResponse likePost(int postId, int userId) {
    }
}
