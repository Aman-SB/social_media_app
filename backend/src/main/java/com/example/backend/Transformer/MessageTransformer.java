package com.example.backend.Transformer;

import com.example.backend.Dto.Response.MessageResponse;
import com.example.backend.Model.Message;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MessageTransformer {

    public static MessageResponse messageToMessageResposne(Message message) {
        if(message == null)return null;
        return MessageResponse.builder()
                .messageId(message.getMessageId())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .sender(UserTransformer.userToUserResponse(message.getSender()))
                .receiver(UserTransformer.userToUserResponse(message.getReceiver()))
                .group(ChatTransformer.chatToChatResponse(message.getChat()))
                .build();
    }

    public static Set<MessageResponse> mapMessageToMessageResponse(Set<Message> messages){
        if(messages == null)return null;
        Set<MessageResponse> messageResponses = new HashSet<>();
        for(Message message : messages){
            messageResponses.add(messageToMessageResposne(message));
        }
        return messageResponses;
    }

    public static List<MessageResponse> listMessageToMessageResponse(List<Message> messages){
        if(messages == null)return null;
        List<MessageResponse> messageResponses = new ArrayList<>();
        for(Message message : messages){
            messageResponses.add(messageToMessageResposne(message));
        }
        return messageResponses;
    }


}
