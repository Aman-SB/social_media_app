package com.example.backend.Transformer;

import com.example.backend.Dto.Request.PostRequest;
import com.example.backend.Dto.Response.MessageResponse;
import com.example.backend.Dto.Response.UserResponse;
import com.example.backend.Model.Message;
import com.example.backend.Model.Post;
import com.example.backend.Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MessageTransformer {

    public static MessageResponse messageToMessageResposne(Message message) {
        return MessageResponse.builder()
                .messageId(message.getMessageId())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .sender(UserTransformer.userToUserResponse(message.getSender()))
                .receiver(UserTransformer.userToUserResponse(message.getReceiver()))
                .group(GroupTransformer.groupToGroupResposne(message.getGroup()))
                .build();
    }

    public static Set<MessageResponse> mapMessageToMessageResponse(Set<Message> messages){
        Set<MessageResponse> messageResponses = new HashSet<>();
        for(Message message : messages){
            messageResponses.add(messageToMessageResposne(message));
        }
        return messageResponses;
    }

    public static List<MessageResponse> listMessageToMessageResponse(List<Message> messages){
        List<MessageResponse> messageResponses = new ArrayList<>();
        for(Message message : messages){
            messageResponses.add(messageToMessageResposne(message));
        }
        return messageResponses;
    }


}
