package com.example.supersaugykla.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;

    public Connection getConnection(){

        String dbName = "duomenusaugykla";
        String userName = "admin";
        String password= "wUp8rkQmwRT2tX3";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
