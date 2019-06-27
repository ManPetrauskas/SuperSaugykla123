package com.example.supersaugykla;

import com.example.supersaugykla.connectivity.ConnectionClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String [] args) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO workers (`First Name`,`Last Name`,`Login Token`,`Total hours`)" +
                " VALUES ('Mantas','Petrauskas','belekas16','0');";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("data inserted");
    }
}
