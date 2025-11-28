package com.example.Gcash.App.operations;

import com.example.Gcash.App.database.Database;
import com.example.Gcash.App.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create {
    public void addOperations(Account account) {
        String sql = "INSERT INTO users(accountId, name, email, number, pin) VALUES(?, ?, ?, ?, ?)";

        try(Connection conn = Database.getConenction();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account.getAccountId());
            stmt.setString(2, account.getName());
            stmt.setString(3, account.getEmail());
            stmt.setString(4, account.getNumber());
            stmt.setString(5, account.getPin());

            int row = stmt.executeUpdate();

            if(row > 0) {
                System.out.println("Register successfull");
            }else {
                System.out.println("Error: No rows were inserted.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
