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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    EditText mail, pass, confrmpass;
    ProgressDialog dialog;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mail = (EditText) findViewById(R.id.editTextEmailsignup);
        pass = (EditText) findViewById(R.id.editTextPasswordsignup);
        confrmpass = (EditText) findViewById(R.id.editTextCnfrmPasswordsignup);
        mAuth = FirebaseAuth.getInstance();
        b1=(Button)findViewById(R.id.btnsignup);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.btnGsignUp);
        b2.setOnClickListener(this);
        findViewById(R.id.edittextlogin).setOnClickListener(this);
    }
    public void register_user() {
        String email = mail.getText().toString();
        String password = pass.getText().toString();
        String passwordconfrm = confrmpass.getText().toString();
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
        if (passwordconfrm.isEmpty()) {
            confrmpass.setError("Password is Empty");
            confrmpass.requestFocus();return;
        }

        if (!password.equalsIgnoreCase(passwordconfrm)) {
            confrmpass.setError("Password Incorrect");
            confrmpass.requestFocus();return;
        }
        dialog=new ProgressDialog(this);
        dialog.show();
        dialog.setMessage("Loading");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.i("info", "createUserWithEmail:success");
                            dialog.dismiss();
                            Intent intent=new Intent(Signup.this,Login.class);
                            startActivity(intent);
                            Toast.makeText(Signup.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();}
                        else {
                           if(task.getException() instanceof FirebaseAuthUserCollisionException){
                               Toast.makeText(Signup.this, "Already Registered", Toast.LENGTH_SHORT).show();
                           }
                           else
                           {
                               Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                           }
                           dialog.dismiss();
                        }

                    }

                });


    }
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnGsignUp:
            Toast.makeText(this, "Available soon", Toast.LENGTH_SHORT).show();
            break;
            case R.id.btnsignup:
                register_user();
                break;
            case R.id.edittextlogin:
                Intent intent=new Intent(this,Login.class);
                startActivity(intent);
                break;

        }
    }
}