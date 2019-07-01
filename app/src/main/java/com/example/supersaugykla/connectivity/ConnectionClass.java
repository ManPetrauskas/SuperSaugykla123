package com.example.supersaugykla.connectivity;

import java.sql.*;


public class ConnectionClass {

    public Connection getConnection() {
        String dbName = "QJOh54KPlC";
        String userName = "QJOh54KPlC";
        String password= "RXNKeQ3fg7";
        String url = "jdbc:mysql://remotemysql.com:3306/";
        try {
            return DriverManager.getConnection(url+dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet executeQuery(String query){
        String dbName = "QJOh54KPlC";
        String userName = "QJOh54KPlC";
        String password= "RXNKeQ3fg7";
        String url = "jdbc:mysql://remotemysql.com:3306/";

        try (
                Connection conn = DriverManager.getConnection(url+dbName, userName, password);
                Statement stmt = conn.createStatement()
        ) {

            return stmt.executeQuery("executeQuery");

        } catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
