package com.example.backend.Service;

import com.example.backend.Dto.Request.UserRequest;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Exception.NoUserPresentException;
import com.example.backend.Exception.PersonAllreadyFollowException;
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

    public User findUserById(int userId){
        Optional<User> optionalUser = userRepository.findById(userId);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found with this " + userId );
        }
        User user = optionalUser.get();
        return user;
    }

    public UserResponse getUserById(int userId) {
        User user = findUserById(userId);
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
        User existingUser = findUserById(userId);

        //updating the user
        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());
        existingUser.setMobileNumber(userRequest.getMobileNumber());
        existingUser.setUsername(userRequest.getUserName());
        existingUser.setBio(userRequest.getBio());
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setProfilePicture(userRequest.getProfilePicture());

        User savedUser = userRepository.save(existingUser);
        return UserTransformer.userToUserResponse(savedUser);
    }

    public boolean deleteUser(int userId) {
        User user = findUserById(userId);
        userRepository.delete(user);
        return true;
    }

    public UserResponse updateUserBio(int userId,String bio) {
        User user = findUserById(userId);
        user.setBio(bio);
        User savedUser = userRepository.save(user);
        return UserTransformer.userToUserResponse(savedUser);
    }

    public UserResponse updateProfilePicture(int userId, String profilePicture) {
        User user = findUserById(userId);
        user.setProfilePicture(profilePicture);
        User savedUser = userRepository.save(user);
        return UserTransformer.userToUserResponse(savedUser);
    }

    public boolean followUser(int userId, int followerId) {
        User user = findUserById(userId);
        User follow = findUserById(followerId);
        List<Integer> userFollowers = user.getFollowers();
        if(userFollowers != null && userFollowers.contains(followerId)){
            throw new PersonAllreadyFollowException("Person Already Followed");
        }
        if(userFollowers == null){
            userFollowers = new ArrayList<>();
        }
        userFollowers.add(followerId);
        user.setFollowers(userFollowers);

        List<Integer> followFollowings = follow.getFollowings();
        if(followFollowings == null){
            followFollowings = new ArrayList<>();
        }
        followFollowings.add(userId);
        follow.setFollowings(followFollowings);

        userRepository.save(user);
        userRepository.save(follow);
        return true;
    }


    public List<UserResponse> getAllFollowers(int userId) {
        User user = findUserById(userId);
        List<Integer> userFollowerList = user.getFollowers();
        List<UserResponse> userResponseList = new ArrayList<>();
        for(int id : userFollowerList){
            userResponseList.add(UserTransformer.userToUserResponse(findUserById(id)));
        }
        return userResponseList;
    }

    public List<UserResponse> getAllFollowings(int userId) {
        User user = findUserById(userId);
        List<Integer> userFollowingList = user.getFollowings();
        List<UserResponse> userResponseList = new ArrayList<>();
        for(int id : userFollowingList){
            userResponseList.add(UserTransformer.userToUserResponse(findUserById(id)));
        }
        return userResponseList;
    }


    public UserResponse findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        System.out.println(user);

        if(user == null){
            throw new UserNotFoundException("User not found with this email id");
        }

        return UserTransformer.userToUserResponse(user);
    }

    public List<UserResponse> searchUser(String query) {
        List<User> users = userRepository.searchUser(query);

        List<UserResponse> userResponseList = new ArrayList<>();

        for(User user : users){
            userResponseList.add(UserTransformer.userToUserResponse(user));
        }

        return userResponseList;
    }
}
