package com.example.manglamconstruction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Fragment fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
        BottomNavigationView navigation = (BottomNavigationView)
                findViewById(R.id.nav_view); navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        fragment=new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case R.id.navigation_images:
                        fragment=new ImageFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                        break;
                    case R.id.navigation_profile:
                        fragment=new MyProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
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
