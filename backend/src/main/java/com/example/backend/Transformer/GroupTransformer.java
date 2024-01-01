package com.example.backend.Transformer;

import com.example.backend.Dto.Response.GroupResponse;
import com.example.backend.Model.Group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupTransformer {
    public static GroupResponse groupToGroupResposne(Group group) {
        return GroupResponse.builder()
                .groupId(group.getGroupId())
                .groupName(group.getGroupName())
                .messages(MessageTransformer.mapMessageToMessageResponse(group.getMessages()))
                .members(UserTransformer.mapUserToUserResponse(group.getMembers()))
                .build();
    }

    public static Set<GroupResponse> mapMessageToMessageResponse(Set<Group> groups){
        Set<GroupResponse> messageResponses = new HashSet<>();
        for(Group group : groups){
            messageResponses.add(groupToGroupResposne(group));
        }
        return messageResponses;
    }

}
