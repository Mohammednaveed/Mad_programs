package com.example.application_iv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button pbutton;
    boolean running;
    int[] pic=new int[]{R.drawable.accenture,R.drawable.ferrari,R.drawable.img,R.drawable.images};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pbutton=(Button) findViewById(R.id.paper_button);
        pbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (!running) {
            new Timer().schedule(new mTimer(), 0, 3000);
            running = true;
        }
    }
    public class mTimer extends TimerTask {


        @Override
        public void run() {

            try {
                WallpaperManager wpm=WallpaperManager.getInstance(getBaseContext());
                Random rn=new Random();
                wpm.setBitmap(BitmapFactory.decodeResource(getResources(),pic[rn.nextInt(4)]));
            } catch (IOException e) {

            }
        }


    }
}