package com.example.manglamconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class projects extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<list> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        people=new ArrayList<list>();
        people.add(new list("Project 1","Chandmari Road"));
        people.add(new list("Project 2","Sandalpur"));
        people.add(new list("Project 3","Ramkrishna Nagar"));
        people.add(new list("Project 4","Ashiana Nagar"));
        people.add(new list("Project 5","Boring Road"));
        people.add(new list("Project 6","Kadamkuan"));
        people.add(new list("Project 7","Hanuman nagar"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }
}
