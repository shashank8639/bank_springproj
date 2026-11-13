package com.bank.bank_springproj.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.bank.bank_springproj.model.BankAcc;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepository implements MyRepo {

	private final JdbcTemplate jdbcTemplate;

	public BankRepository(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
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


	public BankAcc registerAcc(BankAcc account) {
		String sql = "insert into bank_acc(acc_holder, balance, penalty_status,penalized_amount) " +
				" values (?,?,?,?)";
		System.out.println("BankRep: class");
		KeyHolder keyHolder = new GeneratedKeyHolder();


		jdbcTemplate.update(connection->{
			PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
			ps.setString(1, account.getAccHolder());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getPenaltyStatus());
			ps.setDouble(4, account.getPenalizedAmount());

			return  ps;
		}, keyHolder);

		account.setId(keyHolder.getKey().longValue());
		
		return account;
	}

	public List<BankAcc> getAccounts() {

		return jdbcTemplate.query("select * from bank_acc", BANK_ACC_ROW_MAPPER);
	}

}
