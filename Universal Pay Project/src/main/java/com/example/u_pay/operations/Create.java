package com.example.u_pay.operations;

import com.example.u_pay.databases.Database;
import com.example.u_pay.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create {

    public void register(Account acc) {

        String userSql = "INSERT INTO users (accountId, role, fname, lname, email, number, pin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String savingsSql = "INSERT INTO user_savings (accountId, number, savings) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement userStmt = conn.prepareStatement(userSql);
             PreparedStatement savingsStmt = conn.prepareStatement(savingsSql)) {

            conn.setAutoCommit(false);


            // INSERT INTO users
            userStmt.setString(1, acc.getAccountId());
            userStmt.setString(2, acc.getAccountRole());
            userStmt.setString(3, acc.getAccountFirstName());
            userStmt.setString(4, acc.getAccountLastName());
            userStmt.setString(5, acc.getAccountEmail());
            userStmt.setString(6, acc.getAccountNumber());
            userStmt.setInt(7, acc.getAccountPin());
            userStmt.executeUpdate();

            // INSERT INTO user_savings   (default 0)
            savingsStmt.setString(1, acc.getAccountId());
            savingsStmt.setString(2, acc.getAccountNumber());
            savingsStmt.setDouble(3, 0.0);  // initial savings
            savingsStmt.executeUpdate();

            conn.commit(); // Save both inserts together

            System.out.println("Register Successfully (User + Savings Created)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
