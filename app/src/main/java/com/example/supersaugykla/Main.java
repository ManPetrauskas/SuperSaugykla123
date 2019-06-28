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

        String sql = "INSERT INTO workers (`First Name`,`Last Name`,`Login Token`) VALUES ('Vardenis','Pavardenis','gvdsfgbxcg41');";

        String sqlUpdateEndWork = "UPDATE workers SET `Last time ended` = CURRENT_TIMESTAMP WHERE `ID`=15;";

        String sqlUpdateHours = "UPDATE workers SET `Total hours` = TIMESTAMPDIFF(HOUR,`Last time started`,`Last time ended`);";


        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql);                               //Naujas useris
        //statement.executeUpdate(sqlUpdateEndWork);                  //Updatina userio darbo baigima
        statement.executeUpdate(sqlUpdateHours);                    //Updatina visu useriu dienos valandas suskaiciuotas (reik kaskart updatint kad atsinaujintu)
        System.out.println("data inserted");
        connection.close();
    }
}
