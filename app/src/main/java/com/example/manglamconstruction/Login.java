package com.example.manglamconstruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText mail, pass;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.btncreateaccnt).setOnClickListener(this);
        findViewById(R.id.btnlogin).setOnClickListener(this);
        mail=findViewById(R.id.editTextEmail);
        pass=findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
    }

    private void enteraccount() {
        String email = mail.getText().toString();
        String password = pass.getText().toString();
        if (email.isEmpty()) {
            mail.setError("Email is Empty");
            mail.requestFocus();return;
        }
        if (password.isEmpty()) {
            pass.setError("Password is Empty");
            pass.requestFocus();return;
        }
        if (password.length() < 6 && password.length() > 0) {
            pass.setError("Password too short");
            pass.requestFocus();return;
        }
        progressDialog=new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            Toast.makeText(Login.this, "Log in Successful", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(Login.this,projects.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        } else {
                            Log.w("info",task.getException().getMessage(), task.getException());
                            Toast.makeText(Login.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btncreateaccnt:
            {
                Intent intent=new Intent(this,Signup.class);
                startActivity(intent);
                break;
            }
            case R.id.btnlogin:
            {
                enteraccount();
                break;
            }
        }

    }
}

