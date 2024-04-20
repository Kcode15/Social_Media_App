package com.example.socialmediaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.Model.FriendModel;
import com.example.socialmediaapp.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.viewHolder>{

    ArrayList<FriendModel> list;
    Context context;

    public FriendAdapter(ArrayList<FriendModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_rv_sample, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FriendModel model = list.get(position);
        holder.profile.setImageResource(model.getProfile());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView profile;
        public viewHolder(View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_image);

        }
    }
}
