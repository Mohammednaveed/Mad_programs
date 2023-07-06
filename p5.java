package com.example.application_v;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button tb, pb;
    TextView td;
    int counter = 0;
    boolean running = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = (Button) findViewById(R.id.tbutton);
        tb.setOnClickListener(this);
        pb = (Button) findViewById(R.id.pbutton);
        pb.setOnClickListener(this);
        td = (TextView) findViewById(R.id.tdisp);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(tb))
            countstart();
        if (view.equals(pb))
            countstop();
    }

    private void countstop() {
        this.running = false;
        pb.setEnabled(false);
        tb.setEnabled(true);
    }

    Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message m) {
            td.setText(String.valueOf(m.what));
        }

    };

    private void countstart() {

        counter = 0;
        running = true;
        new mcount().start();
        tb.setEnabled(false);
        pb.setEnabled(true);


    }

     class mcount extends Thread {
        public void run() {
            while ((running)) {
                counter++;
                handler.sendEmptyMessage(counter);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}