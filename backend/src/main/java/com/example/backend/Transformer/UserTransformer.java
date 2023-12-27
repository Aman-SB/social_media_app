package com.example.backend.Transformer;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Model.User;

public class UserTransformer {
    public static UserResponse userToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getUserId())
                .userName(user.getUsername())
                .lastName(user.getLastName())
                .firstName(user.getFirstName()).build();
    }

    public static User userRequestToUser(UserRequest userRequest){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .mobileNumber(userRequest.getMobileNumber())
                .username(userRequest.getUserName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .bio(userRequest.getBio())
                .profilePictureURL(userRequest.getProfilePictureURL()).build();
    }

}
