package com.sweng.notty.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sweng.notty.R;
import com.sweng.notty.Utils.MyImageLoader;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private CircleImageView mProfilePhoto;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: navigating to profile editting section.");
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        mProfilePhoto = view.findViewById(R.id.profile_photo);

        ImageView backArrow = view.findViewById(R.id.cross);
        backArrow.setOnClickListener(v -> {
            Log.d(TAG, "onClick: navigating back to ProfileActivity");
            Objects.requireNonNull(getActivity()).finish();
        });

        setupProfilePhoto();

        return view;
    }

    private void setupProfilePhoto() {
        Log.d(TAG, "setupProfilePhoto: setting profile photo");
        String URL = "https://s3.amazonaws.com/37assets/svn/1065-IMG_2529.jpg";
        MyImageLoader.setImage(URL, mProfilePhoto, null, "");
    }
}
