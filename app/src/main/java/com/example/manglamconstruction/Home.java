package com.example.manglamconstruction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {
Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
        BottomNavigationView navigation = (BottomNavigationView)
                findViewById(R.id.nav_view); navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                fragment=null;
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        fragment=new HomeFragment();
                        Log.d("info","home");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        fragment=null;
                        break;
                    case R.id.navigation_images:
                        fragment=new ImageFragment();
                        Log.d("info","image");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        fragment=null;
                        break;
                    case R.id.navigation_profiles:
                        fragment=new MyProfileFragment();
                        Log.d("info","profile");//not working *HARSH RAJ*  //error fixed id was not correct
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        fragment=null;
                        break;
                }

                return true;
            }
        });

    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }
}
