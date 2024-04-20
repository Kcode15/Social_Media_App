package com.example.socialmediaapp.Adapter;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.Model.DashboardModel;
import com.example.socialmediaapp.R;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder>{

    ArrayList<DashboardModel> list;
    Context context;

    public DashboardAdapter(ArrayList<DashboardModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_rv_sample, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DashboardModel model = list.get(position);
        holder.profile.setImageResource(model.getProfile());
        holder.postImage.setImageResource(model.getPostImage());
        holder.name.setText(model.getName());
        holder.about.setText(model.getAbout());
        holder.like.setText(model.getLike());
        holder.comment.setText(model.getComment());
        holder.share.setText(model.getShare());
        holder.name.setTextColor(Color.parseColor("#7360DF"));
        holder.like.setTextColor(Color.parseColor("#7360DF"));
        holder.share.setTextColor(Color.parseColor("#7360DF"));
        holder.comment.setTextColor(Color.parseColor("#7360DF"));
        holder.about.setTextColor(Color.parseColor("#FFFFFF"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profile, postImage, save;
        TextView name, about, like, comment, share;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_image);
            postImage = itemView.findViewById(R.id.postImg);
            save = itemView.findViewById(R.id.save);
            name = itemView.findViewById(R.id.userName);
            about = itemView.findViewById(R.id.about);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
        }
    }
}
