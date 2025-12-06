package com.example.u_pay.operations;

import com.example.u_pay.databases.Database;
import com.example.u_pay.model.Account;
import com.example.u_pay.model.Money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View {
    public static Money getAccount(String number, int pin) {

        String sql = """
            SELECT u.accountId, u.fname, u.lname, u.email, u.number, u.pin, s.savings
            FROM users u
            JOIN user_savings s ON u.accountId = s.accountId
            WHERE u.number = ? AND u.pin = ?""";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.setInt(2, pin);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                Money money = new Money(
                        rs.getString("accountId"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("email"),
                        rs.getString("number"),
                        rs.getInt("pin"),
                        rs.getDouble("savings")
                );

                return money;
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
