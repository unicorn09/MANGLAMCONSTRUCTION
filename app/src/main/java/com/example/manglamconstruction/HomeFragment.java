package com.example.manglamconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment  {
    FirebaseAuth mAuth;ProgressDialog prgd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home,null);
        Button sgnout=(Button)v.findViewById(R.id.button);
        sgnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.button:
                    {
                        prgd=new ProgressDialog(getActivity());
                        prgd.show();
                        prgd.setMessage("Siging Out");
                        FirebaseAuth.getInstance().signOut();
                        Intent i=new Intent(getActivity(),Login.class);
                        Handler handler=new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.i("info","lokoko");//to check
                                prgd.dismiss();
                            }
                        },10000);
                        startActivity(i);
                    }
                }
            }
        });
        return v;
    }
}
