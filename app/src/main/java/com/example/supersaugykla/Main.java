package com.example.supersaugykla;

import com.example.supersaugykla.connectivity.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String [] args) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sql = "INSERT INTO workers (`First Name`,`Last Name`,`Login Token`,`Total hours`, `Last time ended`)" +
                " VALUES ('Alio','Kelmas','belessskas16','0','NULL');";

        String sqlUpdate = "UPDATE workers SET `Last time ended` = CURRENT_TIMESTAMP WHERE `ID`=13;";


        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);                       //Naujas useris
        statement.executeUpdate(sqlUpdate);                 //Updatina userio darbo baigima
        System.out.println("data inserted");
        connection.close();
    }
}
