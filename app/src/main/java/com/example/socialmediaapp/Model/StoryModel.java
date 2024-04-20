package com.example.socialmediaapp.Model;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StoryModel{
    int story, storyType, profile;
    String name;

    public StoryModel(int story, int storyType, int profile, String name) {
        this.story = story;
        this.storyType = storyType;
        this.profile = profile;
        this.name = name;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getStoryType() {
        return storyType;
    }

    public void setStoryType(int storyType) {
        this.storyType = storyType;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}