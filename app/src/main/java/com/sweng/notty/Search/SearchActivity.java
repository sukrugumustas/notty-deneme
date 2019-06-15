package com.sweng.notty.Search;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.sweng.notty.R;
import com.sweng.notty.Utils.BottomNavigationHelper;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "SearchActivity";

    private static final int ACTIVITY_NUM = 1;

    private Context mContext = SearchActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        RelativeLayout rr1 = findViewById(R.layout.deneme);
        Log.d(TAG, "onCreate: started");
        setupBottomNavigationView();
    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setting up bottom navigation view.");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigator);
        BottomNavigationHelper.bottomNavigationHelper(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(mContext, bottomNavigationViewEx);
        bottomNavigationViewEx.getMenu().getItem(ACTIVITY_NUM).setChecked(true);
    }
}
