package com.example.manglamconstruction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    list_adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Data> people;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home_listview,container,false);
        recyclerView=(RecyclerView)(v.findViewById(R.id.list));
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        people=new ArrayList<Data>();
        people.add(new Data("Project 1","Chandmari Road"));
        people.add(new Data("Project 2","Sandalpur"));
        people.add(new Data("Project 3","Ramkrishna Nagar"));
        people.add(new Data("Project 4","Ashiana Nagar"));
        people.add(new Data("Project 5","Boring Road"));
        people.add(new Data("Project 6","Kadamkuan"));
        people.add(new Data("Project 7","Hanuman nagar"));
        myAdapter=new list_adapter(getContext(),people);
        recyclerView.setAdapter(myAdapter);
        return v;
    }
}