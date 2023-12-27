package com.example.backend.Service;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Exception.NoUserPresentException;
import com.example.backend.Exception.UserNotFoundException;
import com.example.backend.Model.User;
import com.example.backend.Repository.UserRepository;
import com.example.backend.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserResponse getUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found with this " + userId );
        }
        User user = optionalUser.get();

        return UserTransformer.userToUserResponse(user);
    }


    public List<UserResponse> getAllUsers() {
        List<User> allUser = userRepository.findAll();

        if(allUser.isEmpty()){
            throw new NoUserPresentException("No User are present");
        }

        List<UserResponse> userResponseList = new ArrayList<>();

        for(User user : allUser){
            userResponseList.add(UserTransformer.userToUserResponse(user));
        }

        return userResponseList;
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = UserTransformer.userRequestToUser(userRequest);

        User saveUser = userRepository.save(user);

        return UserTransformer.userToUserResponse(saveUser);
    }

    public UserResponse updateUser(int userId , UserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User with this " + userId + " not found");
        }

        User existingUser = optionalUser.get();

        //updating the user
        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());
        existingUser.setMobileNumber(userRequest.getMobileNumber());
        existingUser.setUsername(userRequest.getUserName());
        existingUser.setBio(userRequest.getBio());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setProfilePictureURL(userRequest.getProfilePictureURL());

        User savedUser = userRepository.save(existingUser);

        return UserTransformer.userToUserResponse(savedUser);
    }

    public boolean deleteUser(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        User user = optionalUser.get();

        userRepository.delete(user);

        return true;
    }
}
