package com.example.backend.Transformer;

import com.example.backend.Dto.Response.ReelResponse;
import com.example.backend.Model.Reel;

import java.util.ArrayList;
import java.util.List;

public class ReelTransformer {

    public static ReelResponse reelToReelResponse(Reel reel) {
        if(reel == null)return null;
        return ReelResponse.builder()
                .reelId(reel.getReelId())
                .title(reel.getTitle())
                .stories(StoryTransformer.listStoryToStoryResponse(reel.getStories()))
                .build();
    }

    public static List<ReelResponse> listStoryToStoryResponse(List<Reel> reelList){
        if(reelList == null)return null;
        List<ReelResponse> reelResponseList = new ArrayList<>();
        for(Reel story : reelList){
            reelResponseList.add(reelToReelResponse(story));
        }
        return reelResponseList;
    }

}
