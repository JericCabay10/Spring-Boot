package com.example.u_pay.operations;

import com.example.u_pay.databases.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Transaction {

    //Transfer Money
    public static boolean transferMoney(String fromNumber, String toNumber, double amount) {

        String checkBalance = "SELECT savings FROM user_savings WHERE number = ?";
        String updateFrom = "UPDATE user_savings SET savings = savings - ? WHERE number = ?";
        String updateTo = "UPDATE user_savings SET savings = savings + ? WHERE number = ?";

        try (Connection conn = Database.getConnection()) {
            conn.setAutoCommit(false);

            // Check balance
            try (PreparedStatement stmt = conn.prepareStatement(checkBalance)) {
                stmt.setString(1, fromNumber);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next() || rs.getDouble("savings") < amount) {
                    return false;
                }
            }

            // Deduct from sender
            try (PreparedStatement stmt = conn.prepareStatement(updateFrom)) {
                stmt.setDouble(1, amount);
                stmt.setString(2, fromNumber);
                stmt.executeUpdate();
            }

            // Add to receiver
            try (PreparedStatement stmt = conn.prepareStatement(updateTo)) {
                stmt.setDouble(1, amount);
                stmt.setString(2, toNumber);
                int rows = stmt.executeUpdate();
                if (rows == 0) {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();

            save(
                    "Transfer",
                    fromNumber,
                    amount,
                    fromNumber,
                    toNumber
            );

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Cash In Money
    public static boolean cashIn(String accountNumber, double amount) {
        String sql = "UPDATE user_savings SET savings = savings + ? WHERE number = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, amount);
            stmt.setString(2, accountNumber);

            int rows = stmt.executeUpdate();

            if (rows > 0) {

                // SAVE TRANSACTION
                save(
                        "Cash In",
                        accountNumber,
                        amount,
                        null,
                        accountNumber
                );

                return true;
            }

            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void save(String name, String accountId, double amount,
                            String transferFromId, String transferToId) {

        String sql = "INSERT INTO viewTransactions " +
                "(amount, name, accountId, dates, transferToId, transferFromId) " +
                "VALUES (?, ?, ?, NOW(), ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, amount);
            stmt.setString(2, name);
            stmt.setString(3, accountId);
            stmt.setString(4, transferToId);
            stmt.setString(5, transferFromId);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}