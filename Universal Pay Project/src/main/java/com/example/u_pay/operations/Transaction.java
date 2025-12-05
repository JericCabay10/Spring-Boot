package com.example.u_pay.operations;

import com.example.u_pay.databases.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transaction {

    public static boolean transferMoney(String fromNumber, String toNumber, double amount) {
        String checkBalance = "SELECT savings FROM user_savings WHERE number = ?";
        String updateFrom = "UPDATE user_savings SET savings = savings - ? WHERE number = ?";
        String updateTo = "UPDATE user_savings SET savings = savings + ? WHERE number = ?";

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            // 1. Check sender balance
            try (PreparedStatement stmt = conn.prepareStatement(checkBalance)) {
                stmt.setString(1, fromNumber);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    double balance = rs.getDouble("savings");
                    if (balance < amount) {
                        return false; // insufficient funds
                    }
                } else {
                    return false; // sender not found
                }
            }

            // 2. Deduct from sender
            try (PreparedStatement stmt = conn.prepareStatement(updateFrom)) {
                stmt.setDouble(1, amount);
                stmt.setString(2, fromNumber);
                stmt.executeUpdate();
            }

            // 3. Add to recipient
            try (PreparedStatement stmt = conn.prepareStatement(updateTo)) {
                stmt.setDouble(1, amount);
                stmt.setString(2, toNumber);
                int rows = stmt.executeUpdate();
                if (rows == 0) {
                    conn.rollback();
                    return false; // recipient not found
                }
            }

            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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