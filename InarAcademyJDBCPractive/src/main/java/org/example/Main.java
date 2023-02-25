package org.example;
import homework.*;

import javax.xml.transform.Result;
import java.sql.DriverManager;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Question_05.answer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}