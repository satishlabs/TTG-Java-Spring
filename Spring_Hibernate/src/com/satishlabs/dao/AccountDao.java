package com.satishlabs.dao;

import java.util.List;

import com.satishlabs.entity.Account;
import com.satishlabs.exception.DaoException;

public interface AccountDao {
	public void createAccount(Account account) throws DaoException;
	public Account getAccount(String accountNumber) throws DaoException;
	public List<Account> getAllAccounts() throws DaoException;
	public void updateAccount(Account account) throws DaoException;
}
