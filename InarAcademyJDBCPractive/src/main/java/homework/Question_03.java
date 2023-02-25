package homework;

import java.sql.*;
public class Question_03 {
    //What are the names of top 5 categories, that have more than 150 films in inventory of store-1?
    public static void answer() throws SQLException {
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "12832220";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query =
                " SELECT COUNT(name) as film_number ,name\n" +
                "FROM category c\n" +
                "JOIN film_category fc ON c.category_id=fc.category_id\n" +
                "JOIN inventory i ON fc.film_id=i.film_id\n" +
                "WHERE store_id=1\n" +
                "GROUP BY name\n" +
                "HAVING COUNT(name)>=150\n" +
                "ORDER BY COUNT(name)  DESC \n" +
                "LIMIT 5;";

        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){

            System.out.println("film_number: "+resultSet.getString("film_number")+"  Name: "+resultSet.getString("name"));
        }
    }
}