package com.example.u_pay.databases;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Database {
    public static final String URL = "jdbc:mysql://localhost/upay";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456789";

    public static Connection getConnection() {
        Connection conn = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException db) {
            System.out.println("Database error: " + db.getMessage());
        }catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }

        return conn;
    }
}