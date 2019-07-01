package com.example.supersaugykla;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.supersaugykla.connectivity.ConnectionClass;
import com.example.supersaugykla.ui.login.LoginActivity;
import com.example.supersaugykla.ui.login.LoginViewModel;
import com.example.supersaugykla.ui.login.LoginViewModelFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Time extends AppCompatActivity {
    private TextView date1Variable;
    private TextView date2Variable;
    private TextView timeTextVariable;
    private Button startButton;
    private Date firstTimeStamp;
    private Date secondTimeStamp;
    private long timeDiff;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Thread thread;
    private boolean isRunning;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        //==============Cia tureciau matyt true false ar jau pradetas timer bazeje(gauti boolean)=====
        try {
            //LoginActivity.loginToken
            System.out.println(sqlGetBoolean("gvdsfgbxcg41"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //=============================================================================
        if(isRunning){
            //======Tureciau pasiekti pradine data is db ir gauti dabartini total time=================

            //=========================================================================================
        }
        this.startButton = findViewById(R.id.startButton);
        this.date1Variable = findViewById(R.id.date1Text);
        this.date2Variable = findViewById(R.id.date2Text);
        this.timeTextVariable = findViewById(R.id.timeText);
        this.isRunning = false;
        this.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunning){
                    try {
                        stopTimer();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
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
        //===============Timerio pradejimas bazeje ir gavimas pradines datos ir boolean pakeisti=====
        //=======================================================================
        this.firstTimeStamp = new Date();
        this.date1Variable.setText(dateFormat.format(this.firstTimeStamp));
        RefreshTime();
    }
    private void stopTimer() throws SQLException {
        //===============Bazeje timerio uzbaigimas ir total hours suskaiciavimas=======================

        System.out.println(sqlGetBoolean("gvdsfgbxcg41"));

        //============================================================================================
        this.startButton.setText("Start Timer");
        isRunning=false;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void RefreshTime(){
        //================Pasiekti Total time===================================================
        //======================================================================================
        this.secondTimeStamp = new Date();
        this.date2Variable.setText(dateFormat.format(this.secondTimeStamp));
        this.timeDiff=this.secondTimeStamp.getTime()-this.firstTimeStamp.getTime();
        long diffSeconds = this.timeDiff / 1000 % 60;
        long diffMinutes = this.timeDiff / (60 * 1000) % 60;
        long diffHours = this.timeDiff / (60 * 60 * 1000);
        this.timeTextVariable.setText("You are "+diffHours+" h "+diffMinutes+" min "+diffSeconds+" sec  working");
    }

    private void testThread() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<ResultSet>  future = executor.submit(()->executeQuery("SELECT * FROM `workers`"));
        future.get();
    }

    private ResultSet executeQuery(String query){
        String dbName = "QJOh54KPlC";
        String userName = "QJOh54KPlC";
        String password= "RXNKeQ3fg7";
        String url = "jdbc:mysql://remotemysql.com:3306/";

        try (
                Connection conn = DriverManager.getConnection(url+dbName, userName, password);
                Statement stmt = conn.createStatement()
        ) {
            System.out.println(conn);
            return stmt.executeQuery("executeQuery");

        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean sqlGetBoolean(String token) throws SQLException{
        try {
            this.testThread();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        ConnectionClass connectionClass = new ConnectionClass();
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        String query = "SELECT `Checkas` FROM `workers` WHERE `Login Token`='"+token+"'";
//        Future<ResultSet>  future = executor.submit(()->connectionClass.executeQuery(query));
//
//        try {
//            future.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return true;

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your MySQL JDBC Driver?");
//            e.printStackTrace();
//        }
//
//        System.out.println("MySQL JDBC Driver Registered!");
//        Connection connection = null;
//
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/QJOh54KPlC","QJOh54KPlC", "RXNKeQ3fg7");
//
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//        }
//
//        if (connection != null) {
//            System.out.println("You made it, take control your database now!");
//        } else {
//            System.out.println("Failed to make connection!");
//        }

        //
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = connectionClass.getConnection();
//        String sqlGetBoolean = "SELECT `Checkas` FROM `workers` WHERE `Login Token`=\""+token+"\";";
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(sqlGetBoolean);
//        boolean checkas = true;
//        boolean random =rs.next();
//        checkas = rs.getBoolean("Checkas");
//        return checkas;
    }
    /*
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return (Date) java.sql.Date.valueOf(String.valueOf(dateToConvert));
    }
    */
}
