package com.assignment.database;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailRepository implements DataRepository {
    public List<String> getData() {

        List<String> emailList = new ArrayList<>();

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection con = databaseConnection.connectDatabase();
            String sql = "SELECT * FROM email_details";
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                emailList.add(result.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emailList;
    }
}
