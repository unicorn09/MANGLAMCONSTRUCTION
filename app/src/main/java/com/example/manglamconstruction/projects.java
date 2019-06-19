package com.example.manglamconstruction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class projects extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Data> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        people=new ArrayList<Data>();
        people.add(new Data("Project 1","Chandmari Road"));
        people.add(new Data("Project 2","Sandalpur"));
        people.add(new Data("Project 3","Ramkrishna Nagar"));
        people.add(new Data("Project 4","Ashiana Nagar"));
        people.add(new Data("Project 5","Boring Road"));
        people.add(new Data("Project 6","Kadamkuan"));
        people.add(new Data("Project 7","Hanuman nagar"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

        }
    }
}
