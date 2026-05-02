package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sms";
    private static final String USER = "root";
    private static final String PASSWORD = "1096";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected successfully to database!");
        } catch (Exception e) {
            System.out.println("problem starts from here");
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

        return conn;
    }
}