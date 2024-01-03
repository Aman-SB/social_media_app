package com.example.backend.Transformer;
import com.example.backend.Dto.Response.StoryResponse;
import com.example.backend.Model.Story;

import java.util.ArrayList;
import java.util.List;

public class StoryTransformer {

    public static StoryResponse storyToStoryResponse(Story story) {
        if(story == null)return null;
        return StoryResponse.builder()
                .storyId(story.getStoryId())
                .content(story.getContent())
                .createdAt(story.getCreatedAt())
                .user(UserTransformer.userToUserResponse(story.getUser()))
                .reel(ReelTransformer.reelToReelResponse(story.getReel()))
                .build();
    }

    public static List<StoryResponse> listStoryToStoryResponse(List<Story> storyList){
        if(storyList == null)return null;
        List<StoryResponse> storyResponseList = new ArrayList<>();
        for(Story story : storyList){
            storyResponseList.add(storyToStoryResponse(story));
        }
        return storyResponseList;
    }
}
