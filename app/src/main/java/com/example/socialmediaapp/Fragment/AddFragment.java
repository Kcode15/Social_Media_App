package com.example.socialmediaapp.Fragment;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import com.example.socialmediaapp.R;
import androidx.fragment.app.Fragment;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AddFragment extends Fragment {
    Button browse, cam;
    ImageView img;
    private static final int pic_id = 123;
    public AddFragment() {
        super(R.layout.fragment_add);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        browse = view.findViewById(R.id.button);
        cam = view.findViewById(R.id.button1);
        img = view.findViewById(R.id.imageView);

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
                galleryLauncher.launch("image/*");
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new   Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
                cameraLauncher.launch(null);
            }
        });
        return view;
    }


    private final ActivityResultLauncher<String> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            uri -> {
                if (uri != null) {
                    // Handle the selected image URI
                    img.setImageURI(uri);
                }
            });

    private final ActivityResultLauncher<Void> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.TakePicturePreview(),
            bitmap -> {
                if (bitmap != null) {
                    // Handle the captured image bitmap
                    img.setImageBitmap(bitmap);
                }
            });


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
