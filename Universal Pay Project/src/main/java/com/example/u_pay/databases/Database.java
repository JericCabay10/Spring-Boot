package com.example.u_pay.databases;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Database {

    public static final String URL =
        "jdbc:mysql://b9v0ptitp6zosgzpjnid-mysql.services.clever-cloud.com:3306/b9v0ptitp6zosgzpjnid?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    public static final String USERNAME = "uefzrfd6r1n8vwbq";
    public static final String PASSWORD = "CKNyRfbbP63TBrJWoLdk";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException db) {
            System.out.println("Database error: " + db.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }

        return conn;
    }
}
