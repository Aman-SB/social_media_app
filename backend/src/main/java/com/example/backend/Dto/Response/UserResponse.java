package com.example.backend.Dto.Response;

import com.example.backend.Enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class UserResponse {
    int id;

    String firstName;

    String lastName;

    String userName;

    Gender gender;
}
