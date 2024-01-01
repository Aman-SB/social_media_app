package com.example.backend.Controller;

import com.example.backend.Dto.Request.PostRequest;
import com.example.backend.Dto.Response.PostResponse;
import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.Model.Post;
import com.example.backend.Service.PostService;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @PutMapping("/createPost")
    public ResponseEntity createPost(@RequestBody PostRequest postRequest,@RequestParam("userId") int usedId){
        try{
            PostResponse postResponse = postService.createPost(postRequest,usedId);
            return new ResponseEntity(postResponse,HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/postByUserID")
    public ResponseEntity findPostByPostId(@RequestParam("postId") int postId){
        try{
            PostResponse postResponse = postService.findPostByPostId(postId);
            return new ResponseEntity(postResponse,HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity deletePost(@RequestParam("postId") int postId,@RequestParam("userId") int userId){
        try{
            String isDeleted = postService.deletePost(postId,userId);
            return new ResponseEntity(,HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/postAllPost")
    public ResponseEntity findAllPost(@RequestParam("userId") int userId){
        try{
            List<Post> postList = postService.findAllPost(userId);
            return new ResponseEntity(,HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/savePost")
    public ResponseEntity savePost(@RequestParam("postId") int postId,@RequestParam("userId") int userId){
        try{
            PostResponse responsePost = postService.savePost(postId,userId);
            return new ResponseEntity(,HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/postAllPost")
    public ResponseEntity likePost(@RequestParam("postId") int postId,@RequestParam("userId") int userId){
        try{
            PostResponse reponsePost = postService.likePost(postId,userId);
            return new ResponseEntity(,HttpStatus.NOT_FOUND);
        }catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
