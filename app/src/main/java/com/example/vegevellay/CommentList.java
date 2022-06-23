package com.example.vegevellay;

import android.view.View;
import android.view.ViewGroup;

public class CommentList {
    private String nickName;
    private String comment;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        return null;

    }
    CommentList(String nickName, String comment) {
        this.nickName = nickName;
        this.comment = comment;
    }


}
