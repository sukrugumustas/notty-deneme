package com.sweng.notty.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sweng.notty.R;
import com.sweng.notty.Utils.BottomNavigationHelper;
import com.sweng.notty.Utils.MyImageLoader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    private static final int ACTIVITY_NUM = 0;

    private Context mContext = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting: ");
        initImageLoader();
        setupBottomNavigationView();

    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setting up bottom navigation view.");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigator);
        BottomNavigationHelper.bottomNavigationHelper(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(mContext, bottomNavigationViewEx);
        bottomNavigationViewEx.getMenu().getItem(ACTIVITY_NUM).setChecked(true);
    }

    private void initImageLoader (){
        Log.d(TAG, "initImageLoader: initializing image loader");
        MyImageLoader myImageLoader = new MyImageLoader(mContext);
        ImageLoader.getInstance().init(myImageLoader.getConfig());
    }
}
