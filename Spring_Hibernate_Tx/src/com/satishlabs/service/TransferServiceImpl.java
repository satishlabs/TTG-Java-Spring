package com.satishlabs.service;

import com.satishlabs.dao.AccountDao;
import com.satishlabs.entity.Account;
import com.satishlabs.exception.ApplicationException;

public class TransferServiceImpl implements TransferService{
	private  AccountDao accountDao;
	public TransferServiceImpl() {
	}
	
	/**
	 * @param accountDao
	 */ 
	public TransferServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	} 

	/**
	 * @param accountDao the accountDao to set
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void transferFunds(String fromAccount, String destAccount, double amount) throws ApplicationException {
		Account srcAcct = accountDao.getAccount(fromAccount);
		Account destAcct = accountDao.getAccount(destAccount);

		srcAcct.debit(amount);
		destAcct.credit(amount);

		accountDao.updateAccount(srcAcct);
		accountDao.updateAccount(destAcct);
		
	}

}
