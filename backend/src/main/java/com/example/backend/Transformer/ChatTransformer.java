package com.example.backend.Transformer;

import com.example.backend.Dto.Response.ChatResponse;
import com.example.backend.Model.Chat;

import java.util.HashSet;
import java.util.Set;

public class ChatTransformer {
    public static ChatResponse chatToChatResponse(Chat chat) {
        if(chat == null)return null;
        return ChatResponse.builder()
                .chatId(chat.getChatId())
                .chatName(chat.getChatName())
                .messages(MessageTransformer.mapMessageToMessageResponse(chat.getMessages()))
                .members(UserTransformer.mapUserToUserResponse(chat.getMembers()))
                .build();
    }

    public static Set<ChatResponse> mapChatToChatResponse(Set<Chat> chats){
        if(chats == null)return new HashSet<>();
        Set<ChatResponse> messageResponses = new HashSet<>();
        for(Chat chat : chats){
            messageResponses.add(chatToChatResponse(chat));
        }
        return messageResponses;
    }

}
