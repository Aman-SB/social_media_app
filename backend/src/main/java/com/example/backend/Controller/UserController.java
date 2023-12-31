package com.example.backend.Controller;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Exception.NoUserPresentException;
import com.example.backend.Exception.PersonAllreadyFollowException;
import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.Model.User;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.createUser(userRequest);
        return new ResponseEntity(userResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserByID(@PathVariable("userId") int userId){
        try{
            UserResponse userResponse = userService.getUserById(userId);
            return new ResponseEntity(userResponse, HttpStatus.FOUND);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findAllUser")
    public ResponseEntity getAllUsers(){
        try{
            List<UserResponse> allUser = userService.getAllUsers();
            return new ResponseEntity(allUser,HttpStatus.FOUND);
        }
        catch (NoUserPresentException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }


    //test
    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@RequestParam("userId") int UserId , @RequestBody UserRequest userRequest){
        try{
            UserResponse userResponse = userService.updateUser(UserId,userRequest);
            return new ResponseEntity(userResponse,HttpStatus.CREATED);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam("userId") int userId){
        try {
            if(userService.deleteUser(userId)){
                return new ResponseEntity("User deleted Succefully" , HttpStatus.ACCEPTED);
            }
            else{
                throw new NoUserPresentException("No User present in Database");
            }
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
        catch (NoUserPresentException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    //update userbio with userid
    //test
    @PostMapping("/updateBio")
    public ResponseEntity updateUserBio(@RequestParam("userId") int userId , @RequestBody String bio){
        try{
            UserResponse userResponse = userService.updateUserBio(userId,bio);
            return new ResponseEntity(userResponse,HttpStatus.CONTINUE);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    //update profile_picture with userid
//test
    @PutMapping("updateProfilePicture")
    public ResponseEntity updateProfilePicture(@RequestParam("userId") int userId , @RequestBody String profilePicture){
        try{
            UserResponse userResponse = userService.updateProfilePicture(userId,profilePicture);
            return new ResponseEntity(userResponse,HttpStatus.CONTINUE);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    //follow user
    @PutMapping("/followUser")
    public ResponseEntity followUser(@RequestParam("userId1") int userId1,@RequestParam("userId2") int userId2){
        try{
            Boolean followedOrNot = userService.followUser(userId1,userId2);
            return new ResponseEntity(followedOrNot ? "Done Succefully" : "Unsuccesfull",HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
        catch (PersonAllreadyFollowException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    //followings user

    //get all followers
    @GetMapping("/getAllFollowers")
    public ResponseEntity getAllFollowers(@RequestParam("userId") int userId){
        try{
            List<UserResponse> userResponseList = userService.getAllFollowers(userId);
            return new ResponseEntity(userResponseList , HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //get all followings
    @GetMapping("/getAllFollowings")
    public ResponseEntity getAllFollowings(@RequestParam("userId") int userId){
        try{
            List<UserResponse> userResponseList = userService.getAllFollowings(userId);
            return new ResponseEntity(userResponseList , HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findUserByEmail")
    public ResponseEntity findUserByEmail(@RequestParam String email){
        try{
            UserResponse userResponse = userService.findUserByEmail(email);
            return new ResponseEntity(userResponse,HttpStatus.FOUND);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //search user
    @GetMapping("/searchUser")
    public ResponseEntity searchUser(@RequestParam("query") String query){
        try{
            List<UserResponse> userResponseList = userService.searchUser(query);
            return new ResponseEntity(userResponseList,HttpStatus.FOUND);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
