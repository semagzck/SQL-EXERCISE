package org.example;

import java.sql.*;

public class Question {
    public static void answer() throws SQLException {

        //1- Get a connection to DB
        String dbURL ="jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "12832220";
        Connection connection = DriverManager.getConnection(dbURL,username,password);

        //2-create a statement object
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3-execute a query
        String firstQuery = "SELECT title FROM film";
        ResultSet resultSet = statement.executeQuery(firstQuery);


        //4-process the result set
        int count=1;
        while(resultSet.next()){
            System.out.println(count++ +" : "+resultSet.getString("title"));
        }
    }
}
