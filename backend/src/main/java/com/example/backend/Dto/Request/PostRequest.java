package com.example.backend.Dto.Request;

import com.example.backend.Model.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostRequest {

    String caption;

    String image;

    String video;

}
