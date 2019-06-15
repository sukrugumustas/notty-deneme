package com.sweng.notty.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.sweng.notty.R;
import com.sweng.notty.Utils.BottomNavigationHelper;
import com.sweng.notty.Utils.MyImageLoader;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    private static final int ACTIVITY_NUM = 3;

    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;

    private CircleImageView profilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");

        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setupProfilePhoto();
    }

    private void setupActivityWidgets(){
        Log.d(TAG, "setupActivityWidgets: setting up activity widgets");
        mProgressBar = findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = findViewById(R.id.profile_photo);
    }

    private void setupProfilePhoto() {
        Log.d(TAG, "setupProfilePhoto: setting profile photo");
        String URL = "https://s3.amazonaws.com/37assets/svn/1065-IMG_2529.jpg";
        MyImageLoader.setImage(URL, profilePhoto, mProgressBar, "");
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setting up bottom navigation view.");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigator);
        BottomNavigationHelper.bottomNavigationHelper(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(mContext, bottomNavigationViewEx);
        bottomNavigationViewEx.getMenu().getItem(ACTIVITY_NUM).setChecked(true);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);
        ImageView profileMenu = findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(v -> {
            Log.d(TAG, "onClick: navigating to account settings.");
            Intent intent = new Intent(mContext, AccountSettingsActivity.class);
            startActivity(intent);
        });
    }

}
