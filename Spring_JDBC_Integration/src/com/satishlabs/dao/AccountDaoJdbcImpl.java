package com.satishlabs.dao;

import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.satishlabs.entity.Account;
import com.satishlabs.exception.DaoException;

public class AccountDaoJdbcImpl implements AccountDao{
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static RowMapper accountRowMapper = new RowMapper() {
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Account account = new Account();
			account.setAccountNumber(rs.getString("ACCOUNT_NO"));
			account.setAccountOwner(rs.getString("ACCOUNT_OWNER"));
			account.setBalance(rs.getDouble("BALANCE"));
			return account;
		}
	};

	@Override
	public void create(Account account) throws DaoException {
		String sql = "insert into ACCOUNT(ACCOUNT_NO,ACCOUNT_OWNER,BALANCE) values (?,?,?)";
		Object[] params = new Object[] {
				account.getAccountNumber(),
				account.getAccountOwner(),
				account.getBalance()
		};
		int[] types = new int[] {Types.VARCHAR,Types.VARCHAR,Types.DOUBLE};
		try {
			jdbcTemplate.update(sql,params,types);
		}catch (DataAccessException e) {
			throw new DaoException("Unable to add Account : " + account);
		}
	}

	@Override
	public Account getAccount(String accountNumber) throws DaoException {
		String sql = "select ACCOUNT_NO,ACCOUNT_OWNER,"
				+ " BALANCE from ACCOUNT where ACCOUNT_NO = ?";
		try {
			return (Account) jdbcTemplate.queryForObject(sql,
					new Object[] { accountNumber }, accountRowMapper);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to fetch Account : " + accountNumber);
		}
	}

	@Override
	public List<Account> getAllAccounts() throws DaoException {
		String sql = "select ACCOUNT_NO,ACCOUNT_OWNER,"
				+ " BALANCE from ACCOUNT";
		try {
			return jdbcTemplate.query(sql, accountRowMapper);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to get Accounts : ");
		}
	}

	@Override
	public void updateAccount(Account account) throws DaoException {
		String sql = "update ACCOUNT set BALANCE = ? where ACCOUNT_NO = ?";
		Object[] params = new Object[] { account.getBalance(),
				account.getAccountNumber() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DOUBLE };
		try {
			jdbcTemplate.update(sql, params, types);
		} catch (DataAccessException e) {
			throw new DaoException("Unable to update Account : " + account);
		}
	}

}
