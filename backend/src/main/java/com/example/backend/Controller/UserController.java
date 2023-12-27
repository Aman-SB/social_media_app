package com.example.backend.Controller;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Exception.NoUserPresentException;
import com.example.backend.Exception.UserNotFoundException;
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
    public ResponseEntity updateUser(@RequestParam int UserId , @RequestBody UserRequest userRequest){
        try{
            UserResponse userResponse = userService.updateUser(UserId,userRequest);
            return new ResponseEntity(userResponse,HttpStatus.CREATED);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    //test
    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestParam int userId){
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

    //update profile_picture with userid

    //

}
