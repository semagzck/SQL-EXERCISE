package org.example;

import java.sql.*;

public class Question1 {
    public static void answer() throws SQLException {

        String dbURL ="jdbc:postgresql://locaLhost:5432/exercises";
        String username = "postgres";
        String password = "12832220";
        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String firstQuery = "SELECT TO_CHAR(joindate,'Month') AS  month,  COUNT(*)  AS member_amount\n" +
                "FROM cd.members\n" +
                "GROUP BY month\n" +
                "ORDER BY member_amount DESC\n" +
                "LIMIT 1";
        ResultSet resultSet = statement.executeQuery(firstQuery);

        int count=1;
        while(resultSet.next()){

            System.out.print(resultSet.getString("month")+ "\t"+resultSet.getString("member_amount") );

        }
    }

}
