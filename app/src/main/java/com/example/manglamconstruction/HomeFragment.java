package com.example.manglamconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<list> people;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);
        recyclerView=(RecyclerView)(v.findViewById(R.id.list));
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        people=new ArrayList<list>();
        people.add(new list("Project 1","Chandmari Road"));
        people.add(new list("Project 2","Sandalpur"));
        people.add(new list("Project 3","Ramkrishna Nagar"));
        people.add(new list("Project 4","Ashiana Nagar"));
        people.add(new list("Project 5","Boring Road"));
        people.add(new list("Project 6","Kadamkuan"));
        people.add(new list("Project 7","Hanuman nagar"));
        myAdapter=new list_adapter(getContext(),people);
        recyclerView.setAdapter(myAdapter);
        return v;

    }
}
