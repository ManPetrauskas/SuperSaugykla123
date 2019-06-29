package com.example.supersaugykla;

import com.example.supersaugykla.connectivity.ConnectionClass;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
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

    */
        //sqlAddWorkerMethod();
        //sqlUpdateStartWorkMethod("gvdsfgbxcg41");
        //sqlUpdateEndWorkMethod("gvdsfgbxcg41");
        //sqlUpdateHours();
        //System.out.println(sqlGetBoolean("gvdsfgbxcg41"));
        //System.out.println(sqlGetLastTimeStarted("21vdf541gvcx").toString());
        //System.out.println(sqlGetLastTimeEnded("21vdf541gvcx").toString());
        //sqlUpdateBooleanToFalse("gvdsfgbxcg41");
    }

    public static void sqlAddWorkerMethod() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlAddWorker = "INSERT INTO workers (`First Name`,`Last Name`,`Login Token`) VALUES ('Vardenis','Pavardenis','gvdsfgbxcg41');";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlAddWorker);                               //Naujas useris
        System.out.println("Worker inserted");
        connection.close();
    }

    public static void sqlUpdateStartWorkMethod(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateStartWork = "UPDATE workers SET `Last time started` = CURRENT_TIMESTAMP WHERE `Login Token`=\""+token+"\";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlUpdateStartWork);                  //Updatina userio darbo pradzia
        System.out.println("Worker started working");
        connection.close();
    }

    public static void sqlUpdateEndWorkMethod(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateEndWork = "UPDATE workers SET `Last time ended` = CURRENT_TIMESTAMP WHERE `Login Token`=\""+token+"\";";
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

    public static void sqlUpdateBooleanToTrue(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateBooleanToTrue = "UPDATE workers SET `Checkas` = TRUE WHERE `Login Token`=\""+token+"\";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlUpdateBooleanToTrue);
        System.out.println("Boolean changed to true");
        connection.close();
    }

    public static void sqlUpdateBooleanToFalse(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlUpdateBooleanToTrue = "UPDATE workers SET `Checkas` = FALSE WHERE `Login Token`=\""+token+"\";";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlUpdateBooleanToTrue);
        System.out.println("Boolean changed to false");
        connection.close();
    }

    public static boolean sqlGetBoolean(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlGetBoolean = "SELECT `Checkas` FROM `workers` WHERE `Login Token`=\""+token+"\";";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlGetBoolean);
        boolean checkas = true;
        while(rs.next()){
            checkas = rs.getBoolean("Checkas");
        }
        return checkas;
    }

    public static Date sqlGetLastTimeStarted(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlGetBoolean = "SELECT `Last time started` FROM `workers` WHERE `Login Token`=\""+token+"\";";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlGetBoolean);
        rs.next();
        Date checkas = rs.getDate("Last time started");
        return checkas;
    }

    public static Date sqlGetLastTimeEnded(String token) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String sqlGetBoolean = "SELECT `Last time ended` FROM `workers` WHERE `Login Token`=\""+token+"\";";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlGetBoolean);
        rs.next();
        Date checkas = rs.getDate("Last time ended");
        return checkas;
    }
}
