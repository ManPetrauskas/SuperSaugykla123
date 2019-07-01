package com.example.supersaugykla.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;

    public Connection getConnection(){

        String dbName = "QJOh54KPlC";
        String userName = "QJOh54KPlC";
        String password= "RXNKeQ3fg7";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/"+dbName,userName,password);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
