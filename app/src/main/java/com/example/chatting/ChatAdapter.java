package com.example.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<ChatData> mDataset;
    private String myNickName;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView TextView_nickname;
        public TextView TextView_msg;
        public View rootView;

        public MyViewHolder(View view) {
            super(view);
            TextView_nickname = view.findViewById(R.id.TextView_nickname);
            TextView_msg = view.findViewById(R.id.TextView_msg);
            rootView = view;

            view.setClickable(true);
            view.setEnabled(true);

        }
    }
    public ChatAdapter(List<ChatData> myDataset, Context context, String myNickName){
        mDataset = myDataset;
        this. myNickName = myNickName;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat, parent, false);

        MyViewHolder vh =new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChatData chat = mDataset.get(position);

        holder.TextView_nickname.setText(chat.getNickname());
        holder.TextView_msg.setText(chat.getMSG());

        if (chat.getNickname().equals(this.myNickName)){
            holder.TextView_msg.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }
        else{

        }

    }

    @Override
    public int getItemCount() {
        return mDataset==null ? 0 : mDataset.size();

    }
    public ChatData getChat(int position){
        return mDataset != null ? mDataset.get(position) : null ;
    }

    public void addChat(ChatData chat){
        mDataset.add(chat);
        notifyItemInserted(mDataset.size()-1);
    }

}