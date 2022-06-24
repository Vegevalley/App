package com.example.vegevellay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chatListAdapter extends BaseAdapter {
    ArrayList<ChatList> item = new ArrayList<ChatList>();
    private final List<ChatList> data;
    private Map<String,Integer>chatImg;
    Context context;

    public chatListAdapter(List<ChatList>data){
        this.data=data;
        chatImg=new HashMap<>();
        chatImg.put("d",R.drawable.ic_launcher_background);
        chatImg.put("c",R.drawable.ic_launcher_background);

    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
        if(convertView == null){
            holder =new ViewHolder();
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chatlayout,parent,false);

            TextView chatNickname=convertView.findViewById(R.id.chatNickname);
            TextView chatContent=convertView.findViewById(R.id.chatContent);
            ImageView chatImg=convertView.findViewById(R.id.chatProfile);

            holder.chatNickname=chatNickname;
            holder.chatContent=chatContent;
            holder.chatImg=chatImg;

            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        ChatList chatList=data.get(position);
        holder.chatNickname.setText(chatList.getChatNickName());
        holder.chatContent.setText(chatList.getChatContent());
        holder.chatImg.setImageResource(chatImg.get(chatList.getChatProfile()));
        return convertView;

    }
    static class ViewHolder{
        ImageView chatImg;
        TextView chatNickname,chatContent;
    }
}
