package com.example.u_pay.operations;

import com.example.u_pay.databases.Database;
import com.example.u_pay.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View {
    public static Account getAccount(String number, int pin) {
        String sql = "SELECT * FROM users WHERE number = ? AND pin = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setInt(2, pin);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Map database fields to your Account class
                Account account = new Account();
                account.setAccountId(rs.getString("accountId"));
                account.setAccountFirstName(rs.getString("fname"));
                account.setAccountLastName(rs.getString("lname"));
                account.setAccountEmail(rs.getString("email"));
                account.setAccountNumber(rs.getString("number"));
                account.setAccountPin(rs.getInt("pin"));
                return account;
            } else {
                return null; // no matching account
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
