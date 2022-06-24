package com.example.vegevellay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentListAdapter extends BaseAdapter {
    ArrayList<CommentList> item = new ArrayList<CommentList>();
    Context context;

   public CommentListAdapter(Context context, ArrayList<CommentList> item){
       this.context = context;
       this.item = item;
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
        context = parent.getContext();
        CommentList commentList = item.get(position);
        if(convertView == null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.boardcomment,parent,false);
        }
        TextView boardCommentName=convertView.findViewById(R.id.boardCommentName);
        TextView boardCommentNameTxt=convertView.findViewById(R.id.boardCommentNameTxt);

        boardCommentName.setText(commentList.getNickName());
        boardCommentNameTxt.setText(commentList.getComment());

        return convertView;

    }



}
