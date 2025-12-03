package com.example.u_pay.operations;


import com.example.u_pay.databases.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Update {
    public static boolean changePin(String number, int newPin) {
        String sql = "UPDATE users SET pin = ? WHERE number = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newPin);
            stmt.setString(2, number);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
