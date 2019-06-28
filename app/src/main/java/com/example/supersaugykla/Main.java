package com.example.supersaugykla;

import com.example.supersaugykla.connectivity.ConnectionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String [] args) throws SQLException {/*

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sqlAddWorker = "INSERT INTO workers (`First Name`,`Last Name`,`Login Token`) VALUES ('Vardenis','Pavardenis','gvdsfgbxcg41');";

        String sqlUpdateStartWork = "UPDATE workers SET `Last time started` = CURRENT_TIMESTAMP WHERE `ID`=1;";
        String sqlUpdateEndWork = "UPDATE workers SET `Last time ended` = CURRENT_TIMESTAMP WHERE `ID`=15;";

        String sqlUpdateHours = "UPDATE workers SET `Total hours` = TIMESTAMPDIFF(HOUR,`Last time started`,`Last time ended`);";


        Statement statement = connection.createStatement();
        //statement.executeUpdate(sqlAddWorker);                               //Naujas useris
        //statement.executeUpdate(sqlUpdateStartWork);                  //Updatina userio darbo pradzia
        //statement.executeUpdate(sqlUpdateEndWork);                  //Updatina userio darbo baigima
        statement.executeUpdate(sqlUpdateHours);                    //Updatina visu useriu dienos valandas suskaiciuotas (reik kaskart updatint kad atsinaujintu)
        System.out.println("data inserted");
        connection.close();
    */}

    public static void sqlAddWorkerMethod() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        String sqlAddWorker = "INSERT INTO workers (`First Name`,`Last Name`,`Login Token`) VALUES ('Vardenis','Pavardenis','gvdsfgbxcg41');";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlAddWorker);                               //Naujas useris
        System.out.println("Worker inserted");
        connection.close();
    }

    public static void sqlUpdateStartWorkMethod() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateStartWork = "UPDATE workers SET `Last time started` = CURRENT_TIMESTAMP WHERE `ID`=1;";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlUpdateStartWork);                  //Updatina userio darbo pradzia
        System.out.println("Worker started working");
        connection.close();
    }

    public static void sqlUpdateEndWorkMethond() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateEndWork = "UPDATE workers SET `Last time ended` = CURRENT_TIMESTAMP WHERE `ID`=15;";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlUpdateEndWork);                  //Updatina userio darbo baigima
        System.out.println("Worker stopped working");
        connection.close();
    }

    public static void sqlUpdateHours() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateHours = "UPDATE workers SET `Total hours` = TIMESTAMPDIFF(HOUR,`Last time started`,`Last time ended`);";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlUpdateHours);                    //Updatina visu useriu dienos valandas suskaiciuotas (reik kaskart updatint kad atsinaujintu)
        System.out.println("Total hours updated");
        connection.close();
    }
}
