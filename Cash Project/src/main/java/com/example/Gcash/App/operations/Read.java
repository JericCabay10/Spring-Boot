package com.example.Gcash.App.operations;

import com.example.Gcash.App.database.Database;
import com.example.Gcash.App.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
    public Account userLogin(String number, String pin) {
        String sql = "SELECT * FROM users WHERE number = ? AND pin = ?";

        try (Connection conn = Database.getConenction();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setString(2, pin);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                // Create Account object from DB result
                return new Account(
                        result.getString("accountId"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("number"),
                        result.getString("pin")
                );
            } else {
                return null; // login failed
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
