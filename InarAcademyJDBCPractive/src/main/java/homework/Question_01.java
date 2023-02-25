package homework;

import java.sql.*;

public class Question_01 {
    public static void answer() throws SQLException {
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "12832220";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "SELECT c.first_name ||' ' || c.last_name AS full_name ,rental_date FROM actor a\n" +
                "INNER JOIN film_actor fa ON a.actor_id =fa.actor_id\n" +
                "INNER JOIN inventory i ON i.film_id=fa.film_id \n" +
                "INNER JOIN rental r ON r.inventory_id = i.inventory_id\n" +
                "INNER JOIN customer c ON c.customer_id =r.customer_id\n" +
                "WHERE a.first_name='Ed'AND a.last_name='Chase'\n" +
                "ORDER BY rental_date DESC\n" +
                "LIMIT 3;";
        ResultSet resultSet=statement.executeQuery(query);
        while(resultSet.next()){
            String full_name =resultSet.getString("full_name");
            String rental_date=resultSet.getString("rental_date");
            System.out.println(full_name + "         " + rental_date);
        }
    }
}