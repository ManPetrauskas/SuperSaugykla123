package com.example.supersaugykla;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalDate;
import java.util.Date;

public class Time extends AppCompatActivity {
    private TextView date1Variable;
    private TextView date2Variable;
    private TextView timeTextVariable;
    private Button startButton;
    private Date firstTimeStamp;
    private Date secondTimeStamp;
    private long timeDiff;
    private Thread thread;
    private boolean isRunning;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        this.startButton = findViewById(R.id.startButton);
        this.date1Variable = findViewById(R.id.date1Text);
        this.date2Variable = findViewById(R.id.date2Text);
        this.timeTextVariable = findViewById(R.id.timeText);
        this.isRunning = false;
        this.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunning){
                    stopTimer();
                }
                else {
                    startTimer();
                }
            }
        });
        this.thread = new Thread() {

            @Override
            public void run() {
                try {
                    while (!thread.isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(isRunning){
                                    RefreshTime();
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        thread.start();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void startTimer(){
        this.startButton.setText("Stop Timer");
        isRunning=true;
        this.firstTimeStamp = convertToDateViaSqlDate(LocalDate.now());
        this.date1Variable.setText(firstTimeStamp.toString());
    }
    private void stopTimer(){
        this.startButton.setText("Start Timer");
        isRunning=false;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void RefreshTime(){
        this.secondTimeStamp = convertToDateViaSqlDate(LocalDate.now());
        this.date2Variable.setText(this.secondTimeStamp.toString());
        this.timeDiff=this.secondTimeStamp.getTime()-this.firstTimeStamp.getTime();
        long diffSeconds = this.timeDiff / 1000 % 60;
        long diffMinutes = this.timeDiff / (60 * 1000) % 60;
        long diffHours = this.timeDiff / (60 * 60 * 1000);
        this.timeTextVariable.setText("You are "+diffHours+" h "+diffMinutes+" min "+diffSeconds+" sec  working");
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return (Date) java.sql.Date.valueOf(String.valueOf(dateToConvert));
    }
}
