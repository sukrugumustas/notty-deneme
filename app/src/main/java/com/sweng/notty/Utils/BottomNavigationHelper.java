package com.sweng.notty.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.sweng.notty.Main.MainActivity;
import com.sweng.notty.Profile.ProfileActivity;
import com.sweng.notty.R;
import com.sweng.notty.Search.SearchActivity;
import com.sweng.notty.Upload.UploadActivity;

public class BottomNavigationHelper {

    public static final String TAG = BottomNavigationHelper.class.getSimpleName();

    public static void bottomNavigationHelper(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setting up other properties of navbar.");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation (final Context context, BottomNavigationViewEx bottomNavigationViewEx) {

        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.bottom_menu_home: //ACTIVITY_NUM = 0
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                        break;

                    case R.id.bottom_menu_search:   //ACTIVITY_NUM = 1
                        Intent intent2 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.bottom_menu_upload:   //ACTIVITY_NUM = 2
                        Intent intent3 = new Intent(context, UploadActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.bottom_menu_profile:  //ACTIVITY_NUM = 3
                        Intent intent4 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent4);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem);
                }

                return false;
            }
        });

    }

    public static int getSelectedItem(BottomNavigationViewEx bottomNavigationViewEx) {
        Menu menu = bottomNavigationViewEx.getMenu();
        for (int i = 0; i<menu.size(); i++) {
            if (menu.getItem(i).isChecked()) {
                return i;
            }
        }
        return 0;
    }



}
