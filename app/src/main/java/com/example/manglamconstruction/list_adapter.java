package com.example.manglamconstruction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class list_adapter extends RecyclerView.Adapter<list_adapter.MyViewHolder> {
    private ArrayList<Data> list1;
    public list_adapter(Context context,ArrayList<Data> list1)
    {
        this.list1=list1;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView address,number;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.address=(TextView)itemView.findViewById(R.id.tv_address);
            this.number=(TextView)itemView.findViewById(R.id.tv_projectnumber);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_home_listview,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag((list1.get(i)));
        viewHolder.address.setText(list1.get(i).getName());
        viewHolder.number.setText(list1.get(i).getNum());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
}

 class Data {
     String name;
     String num;

    public String getNum() {

        return num;
    }

    public Data(String name, String num) {
        this.name = name;
        this.num=num;
    }

    public String getName() {
        return name;
    }


}