package com.example.manglamconstruction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class splash extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.raw_music_splash);
        //mediaPlayer.start();
        TextView Text2=(TextView)findViewById(R.id.textView2);
        Text2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.textView2:
            {
                Intent intent=new Intent(this,Login.class);
                startActivity(intent);
            }
        }
    }
}

