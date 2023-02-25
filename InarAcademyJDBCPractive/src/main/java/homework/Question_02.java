package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class Question_02 {
    public static void answer() throws SQLException {
//Find the staff’s name, username and password who is working in the store that sells “Glass Dying” film
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "12832220";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query =
                        "SELECT DISTINCT first_name ||' '||last_name AS name,username,password FROM staff s\n" +
                        "INNER JOIN inventory i ON s.store_id =i.store_id\n" +
                        "INNER JOIN film f ON i.film_id = f.film_id\n" +
                        "WHERE f.title = 'Glass Dying';" ;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            String name = resultSet.getString("name");
            String username1 = resultSet.getString("username");
            String password1= resultSet.getString("password");


            System.out.println(name + "     "   + username1 +  "  " +  password1 );
        }
    }


}