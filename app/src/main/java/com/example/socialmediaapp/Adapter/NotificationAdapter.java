package com.example.socialmediaapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.Model.NotificationModel;
import com.example.socialmediaapp.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.viewHolder>{

    ArrayList<NotificationModel> list;
    Context context;

    public NotificationAdapter(ArrayList<NotificationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.notification2sample, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        NotificationModel model = list.get(position);

        holder.profile.setImageResource(model.getProfile());
        holder.notification.setText(HtmlCompat.fromHtml(model.getNotification(), HtmlCompat.FROM_HTML_MODE_LEGACY));
        holder.time.setText(model.getTime());
        holder.notification.setTextColor(Color.parseColor("FFFFFF"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView profile;
        TextView notification, time;

        public viewHolder(@NonNull View itemView) {

            super(itemView);

            profile = itemView.findViewById(R.id.profile_image);
            notification = itemView.findViewById(R.id.notification);
            time = itemView.findViewById(R.id.time);
        }
    }

}
