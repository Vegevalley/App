package com.example.vegevellay;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
    ArrayList<ChatList> arrayList;
    chatListAdapter arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        arrayList=new ArrayList<>();
        arrayList.add(new ChatList("d","익1","안녕하세요"));
        arrayList.add(new ChatList("c","익2","아직있나요?"));

        arrayAdapter=new chatListAdapter(arrayList);
        listView=(ListView)findViewById(R.id.chatList);
        listView.setAdapter(arrayAdapter);
    }
}
