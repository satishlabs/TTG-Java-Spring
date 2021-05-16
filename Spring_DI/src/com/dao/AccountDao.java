package com.dao;

import java.util.List;

import com.entity.Account;

/**
 * @author Satish
 *
 */
public interface AccountDao {
	public void create(Account account);
	public Account getAccount(String accountNumber);
	public List<Account> getAllAccount();
	public void updateAccount(Account account);
}
