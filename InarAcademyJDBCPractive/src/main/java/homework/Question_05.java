package homework;

import java.sql.*;

public class Question_05 {
    //5-How much will store-2 earn when all the rented films are returned?
    public static void answer() throws SQLException {

        String dbUrl = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "postgres";
        String password = "12832220";

        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query =
                       "SELECT i.store_id,SUM(amount) FROM payment p\n" +
                       "INNER JOIN rental r ON r.rental_id = p.rental_id\n" +
                       "INNER JOIN inventory i ON i.inventory_id = r.inventory_id\n" +
                       "WHERE store_id = 2\n" +
                       "GROUP BY store_id;\n";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            String store_id = resultSet.getString("store_id");
            String sum = resultSet.getString("sum");
            System.out.println(store_id + "\t" + sum);
        }
    }
}