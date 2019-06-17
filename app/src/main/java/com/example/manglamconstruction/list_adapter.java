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

public class list_adapter extends RecyclerView.Adapter<list_adapter.ViewHolder> {
    private ArrayList<list> list1;
    private RecyclerView.ViewHolder viewHolder;
    private int i;

    public list_adapter(Context context,ArrayList<list> list1)
    {
        this.list1=list1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView address,number;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            address=itemView.findViewById(R.id.tv_address);
            number=itemView.findViewById(R.id.projectnumber);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "clicked item is "+address.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public list_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_home_listview,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull list_adapter.ViewHolder viewHolder, int i) {

       viewHolder.itemView.setTag(list1.get(i));
       viewHolder.address.setText(list1.get(i).getName());
       viewHolder.number.setText(list1.get(i).getNum());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
}
