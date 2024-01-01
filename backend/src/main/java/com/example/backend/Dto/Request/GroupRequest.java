package com.example.backend.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupRequest {

    String groupName;

    Set<Integer> memberIds;
}
