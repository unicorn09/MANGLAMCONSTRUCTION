package com.example.manglamconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class projects extends AppCompatActivity implements View.OnClickListener {
    Button sgnout;
    ProgressDialog prgd;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        findViewById(R.id.btnsignout);
        mAuth=FirebaseAuth.getInstance();
        sgnout=(Button)findViewById(R.id.btnsignout);
        sgnout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnsignout:
            {
                prgd=new ProgressDialog(this);
                prgd.show();
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(this,Login.class);
                prgd.dismiss();
                startActivity(i);
            }
        }
    }
}
