package com.example.backend.Dto.Request;

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

    String profilePictureURL;

    String email;

    String password;

}
