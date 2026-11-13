package com.bank.bank_springproj.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.bank.bank_springproj.model.BankAcc;
import org.springframework.stereotype.Repository;

@Repository
public class BankJDBC implements MyRepo{

    private final DataSource dataSource;

    // Constructor injection for DataSource managed by Spring Boot
    public BankJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public BankAcc registerAcc(BankAcc account) {
        final String sql =
                "INSERT INTO bank_acc (acc_holder, balance, penalty_status, penalized_amount) " +
                        "VALUES (?, ?, ?, ?)";

        // Opens a connection from Spring's configured connection pool
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, account.getAccHolder());
            ps.setDouble(2, account.getBalance());
            ps.setString(3, account.getPenaltyStatus());
            ps.setDouble(4, account.getPenalizedAmount());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        account.setId(generatedKeys.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting account into database", e);
        }

        return account;
    }

    public List<BankAcc> getAccounts() {
        List<BankAcc> accounts = new ArrayList<>();
        final String sql = "SELECT * FROM bank_acc ORDER BY id";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                BankAcc acc = new BankAcc();
                acc.setId(rs.getLong("id"));
                acc.setAccHolder(rs.getString("acc_holder"));
                acc.setBalance(rs.getDouble("balance"));
                acc.setPenaltyStatus(rs.getString("penalty_status"));
                acc.setPenalizedAmount(rs.getDouble("penalized_amount"));
                accounts.add(acc);
            }
            System.out.println("====executed=======");
            System.out.println(accounts);
            System.out.println("===========");
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching accounts from database", e);
        }

        return accounts;
    }
}