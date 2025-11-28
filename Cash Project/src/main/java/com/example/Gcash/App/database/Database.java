package com.example.Gcash.App.database;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/gcash";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Connection getConenction() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("✔ DATABASE CONNECTED Successfully!");
        } catch(SQLException con) {
            System.out.println("❌ SQL Connection Error: " + con.getMessage());
        } catch(Exception e) {
            System.out.println("❌ General Error: " + e.getMessage());
        }


        return conn;
    }
}
