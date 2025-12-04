package com.example.u_pay.operations;

import com.example.u_pay.databases.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Transaction {

    // Existing transferMoney method...

    // Cash In money
    public static boolean cashIn(String accountNumber, double amount) {
        String sql = "UPDATE user_savings SET savings = savings + ? WHERE number = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, amount);
            stmt.setString(2, accountNumber);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
