package com.example.u_pay.operations;


import com.example.u_pay.databases.Database;
import com.example.u_pay.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create {
    public void register(Account acc) {

        String sql = "INSERT INTO users (accountId, fname, lname, email, number, pin) VALUES(?, ?, ?, ?, ?, ?)";

        try(Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, acc.getAccountId());
            stmt.setString(2, acc.getAccountFirstName());
            stmt.setString(3, acc.getAccountLastName());
            stmt.setString(4, acc.getAccountEmail());
            stmt.setString(5, acc.getAccountNumber());
            stmt.setInt(6, acc.getAccountPin());

            stmt.executeUpdate();
            System.out.println("Register Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
