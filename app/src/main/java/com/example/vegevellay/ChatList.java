package com.example.vegevellay;

import android.view.View;
import android.view.ViewGroup;

public class ChatList {
    private String chatNickName;
    private String chatContent;
    private String chatProfile;

    public String getChatNickName() {
        return chatNickName;
    }

    public void setchatNickName(String chatNickName) {
        this.chatNickName = chatNickName;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent= chatContent;
    }
    public String getChatProfile() {
        return chatProfile;
    }

    public void setChatProfile(String chatProfile) {
        this.chatContent= chatProfile;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        return null;
    }
    ChatList(String chatProfile, String chatNickName, String chatContent) {
        this.chatProfile=chatProfile;
        this.chatNickName = chatNickName;
        this.chatContent = chatContent;
    }
}
