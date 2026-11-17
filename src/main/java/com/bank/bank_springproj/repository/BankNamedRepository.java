package com.bank.bank_springproj.repository;

import com.bank.bank_springproj.model.BankAcc;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BankNamedRepository implements MyRepo {

    // 1. Inject NamedParameterJdbcTemplate instead of JdbcTemplate
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BankNamedRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static final RowMapper<BankAcc> BANK_ACC_ROW_MAPPER =
            (rs, rowNum) ->
                    new BankAcc(
                            rs.getLong("id"),
                            rs.getString("acc_holder"),
                            rs.getDouble("balance"),
                            rs.getString("penalty_status"),
                            rs.getDouble("penalized_amount")
                    );

    @Override
    public BankAcc registerAcc(BankAcc account) {
        String sql = "INSERT INTO bank_acc (acc_holder, balance, penalty_status, penalized_amount) " +
                "VALUES (:accHolder, :balance, :penaltyStatus, :penalizedAmount)";

        // 2. Bind parameters using MapSqlParameterSource (matches keys to :names in SQL)
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("accHolder", account.getAccHolder())
                .addValue("balance", account.getBalance())
                .addValue("penaltyStatus", account.getPenaltyStatus())
                .addValue("penalizedAmount", account.getPenalizedAmount());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        // 3. Execute update with named parameters
        namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[]{"id"});

        if (keyHolder.getKey() != null) {
            account.setId(keyHolder.getKey().longValue());
        }

        return account;
    }

    @Override
    public List<BankAcc> getAccounts() {
        // For queries with no parameters, you can pass an empty map or null
        return namedParameterJdbcTemplate.query("SELECT * FROM bank_acc", BANK_ACC_ROW_MAPPER);
    }
}