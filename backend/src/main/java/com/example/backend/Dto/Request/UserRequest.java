package com.example.backend.Dto.Request;

import com.example.backend.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {

    String firstName;

    String lastName;

    String mobileNumber;

    String userName;

    String bio;

    Gender gender;

    String profilePicture;

    String email;

    String password;

}


