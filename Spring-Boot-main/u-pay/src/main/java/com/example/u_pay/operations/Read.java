package com.example.u_pay.operations;


import com.example.u_pay.databases.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {
    public static boolean validatePin(String number, int pin) {
        String sql = "SELECT * FROM users WHERE number = ? AND pin = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setInt(2, pin);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true if number+pin matches
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
