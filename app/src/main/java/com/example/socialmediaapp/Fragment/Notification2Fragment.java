package com.example.socialmediaapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialmediaapp.Adapter.NotificationAdapter;
import com.example.socialmediaapp.Model.NotificationModel;
import com.example.socialmediaapp.R;

import java.util.ArrayList;

public class Notification2Fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<NotificationModel> list;

    public Notification2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification2, container, false);
        recyclerView = view.findViewById(R.id.notification2RV);
        list = new ArrayList<>();

        list.add(new NotificationModel(R.drawable.rachel, "<b>Rachel Gill</b> Mentioned you in Story", "just now"));
        list.add(new NotificationModel(R.drawable.shanaya, "<b>Shanaya Maxwell</b> Sent a Chat", "just now"));
        list.add(new NotificationModel(R.drawable.john, "<b>John Moses</b> Sent an Image", ".1hr"));
        list.add(new NotificationModel(R.drawable.simi, "<b>Simi Abbey</b> Mentioned you in Story", ".2hr"));
        list.add(new NotificationModel(R.drawable.profile, "<b>Denis Kane</b> Deleted a Message", ".2hr"));
        list.add(new NotificationModel(R.drawable.extra1, "<b>Harley Merry</b> Sent a Chat", ".1d"));
        list.add(new NotificationModel(R.drawable.extra2, "<b>Jack</b> Sent a Chat", ".2d"));

        NotificationAdapter adapter = new NotificationAdapter(list, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}