package com.example.socialmediaapp.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialmediaapp.Adapter.DashboardAdapter;
//import com.example.socialmediaapp.Adapter.StoryAdapter;
import com.example.socialmediaapp.Model.DashboardModel;
import com.example.socialmediaapp.Model.StoryModel;
import com.example.socialmediaapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<StoryModel> storyList;
    private ArrayList<DashboardModel> dashboardList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    // Inflate the layout for this fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
       // RecyclerView storyRv = view.findViewById(R.id.storyRV);
        storyList = new ArrayList<>();
       // StoryAdapter storyAdapter = new StoryAdapter(storyList, getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        storyRv.setLayoutManager(layoutManager);
//        storyRv.setAdapter(storyAdapter);
        RecyclerView dashboardRv = view.findViewById(R.id.dashboardRv);
        dashboardList = new ArrayList<>();
        dashboardList.add(new DashboardModel(R.drawable.smritip, R.drawable.smriti, R.drawable.bookmark_color,R.drawable.line,"Smriti Mandhana", "Cricketer", "1M", "1000", "10"));
        dashboardList.add(new DashboardModel(R.drawable.anup, R.drawable.anu1, R.drawable.bookmark_color,R.drawable.line,"Anushka Sharma", "Actress", "10M", "2000", "200"));
        dashboardList.add(new DashboardModel(R.drawable.coldp1, R.drawable.coldp3, R.drawable.bookmark_color,R.drawable.line,"Coldplay", "Music Band", "3M", "5000", "1500"));
        DashboardAdapter dashboardAdapter = new DashboardAdapter(dashboardList, getContext());
        LinearLayoutManager dashboardLayoutManager = new LinearLayoutManager(getContext());
        dashboardRv.setLayoutManager(dashboardLayoutManager);
        dashboardRv.setAdapter(dashboardAdapter);

        return view;
    }
}

// Inside your onCreateView() method in the Fragment
