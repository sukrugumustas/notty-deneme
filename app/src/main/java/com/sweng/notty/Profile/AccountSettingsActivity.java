package com.sweng.notty.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.sweng.notty.R;
import com.sweng.notty.Utils.BottomNavigationHelper;
import com.sweng.notty.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    public static final int ACTIVITY_NUM = 3;

    private Context mContext = AccountSettingsActivity.this;
    public SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        Log.d(TAG, "onCreate: Account settings started.");

        mViewPager = findViewById(R.id.container);
        mRelativeLayout = findViewById(R.id.relLayout1);

        setupBottomNavigationView();
        setupSettingsList();
        setupFragments();

        //Back Arrow Settings

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(v -> {
            Log.d(TAG, "onClick: Returning back to Profile Activity");
            finish();
        });
    }

    private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit)); //fragment 0
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.signout)); //fragment 1
    }

    public void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragment #: " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }





    private void setupBottomNavigationView() {
        Log.d(TAG, "setting up bottom navigation view.");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigator);
        BottomNavigationHelper.bottomNavigationHelper(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(mContext, bottomNavigationViewEx);
        bottomNavigationViewEx.getMenu().getItem(ACTIVITY_NUM).setChecked(true);
    }

    private void setupSettingsList() {
        Log.d(TAG, "setupSettingsList: Setting up account settings list.");
        ListView listView = findViewById(R.id.lvAccountSettings);
        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit));
        options.add(getString(R.string.signout));
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.d(TAG, "onItemClick: navigating to fragment#: " + position);
            setViewPager(position);
        });
    }
}
