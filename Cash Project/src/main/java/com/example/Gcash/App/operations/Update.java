package com.example.Gcash.App.operations;

import com.example.Gcash.App.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
    public void updatePin(String number, String newPin) {
        String sql = "UPDATE users SET pin = ? WHERE number = ?";

        try(Connection conn = Database.getConenction();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setString(2, newPin);

            int update = stmt.executeUpdate();

            if(update > 0) {
                System.out.println("PIN updated successfully for number: " + number);
            } else {
                System.out.println("No user found with number: " + number);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
