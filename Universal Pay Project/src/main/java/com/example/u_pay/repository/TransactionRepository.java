package com.example.u_pay.repository;

import com.example.u_pay.databases.Database;
import com.example.u_pay.model.ViewTransaction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    public List<ViewTransaction> findByAccountId(String accountId) {

        List<ViewTransaction> list = new ArrayList<>();

        String sql = "SELECT * FROM viewTransactions WHERE accountId = ? ORDER BY dates DESC";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, accountId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ViewTransaction t = new ViewTransaction();
                t.setAmount(rs.getDouble("amount"));
                t.setName(rs.getString("name"));
                t.setAccountId(rs.getString("accountId"));
                t.setDates(rs.getString("dates"));
                t.setTransferToId(rs.getString("transferToId"));
                t.setTransferFromId(rs.getString("transferFromId"));
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
