package com.example.backend.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
public class UserExtraDetailsResponse extends UserResponse{
    String profilePictureURL;

    List<Integer> followers;

    List<Integer> followings;
}
