package com.example.socialmediaapp.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.socialmediaapp.Adapter.DashboardAdapter;
import com.example.socialmediaapp.Adapter.FriendAdapter;
import com.example.socialmediaapp.Model.DashboardModel;
import com.example.socialmediaapp.Model.FriendModel;
import com.example.socialmediaapp.R;
import com.example.socialmediaapp.SignUpActivity;
import com.example.socialmediaapp.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<FriendModel> list;
    FragmentProfileBinding binding;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    private ArrayList<DashboardModel> dashboardList;
    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        auth=FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        binding=FragmentProfileBinding.inflate(inflater,container,false);

        list = new ArrayList<>();
        list.add(new FriendModel(R.drawable.simi));
        list.add(new FriendModel(R.drawable.john));
        list.add(new FriendModel(R.drawable.shanaya));
        list.add(new FriendModel(R.drawable.rachel));
        list.add(new FriendModel(R.drawable.profile));

        FriendAdapter adapter = new FriendAdapter(list, getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.friendRV.setLayoutManager(linearLayoutManager);
        binding.friendRV.setAdapter(adapter);

        binding.changeCoverPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,11);
            }
        });
        dashboardList = new ArrayList<>();
        dashboardList.add(new DashboardModel(R.drawable.v5, R.drawable.virat1, R.drawable.bookmark_color,R.drawable.line,"Virat Kohli", "New York", "20M", "9000", "600"));
        dashboardList.add(new DashboardModel(R.drawable.v5, R.drawable.v6, R.drawable.bookmark_color,R.drawable.line,"Virat Kohli", "London", "30M", "10000", "400"));
        dashboardList.add(new DashboardModel(R.drawable.v5, R.drawable.virat4, R.drawable.bookmark_color,R.drawable.line,"Virat Kohli", "India", "50M", "5000", "500"));

        DashboardAdapter dashboardAdapter = new DashboardAdapter(dashboardList, getContext());
        LinearLayoutManager dashboardLayoutManager = new LinearLayoutManager(getContext());
        binding.dashboardRv.setLayoutManager(dashboardLayoutManager);

// Set the adapter to the RecyclerView
        binding.dashboardRv.setAdapter(dashboardAdapter);

        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getData()!=null){
            Uri uri=data.getData();
            binding.coverPhoto.setImageURI(uri);

            final StorageReference reference = storage.getReference("cover_photo").child(FirebaseAuth.getInstance().getUid());
            reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getContext(),"Cover Photo changed successfully",Toast.LENGTH_SHORT).show();
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference().child("Users").child(auth.getUid()).child("coverPhoto").setValue(uri.toString());
                        }
                    });
                }
            });
        }
    }
}