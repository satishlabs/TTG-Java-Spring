package com.satishlabs.service;

import com.satishlabs.exception.ApplicationException;

public interface TransferService {
	/**
	 * @param fromAccount
	 * @param destAccount
	 * @param amount
	 * @throws ApplicationException 
	 */
	void transferFunds(String fromAccount, String destAccount, double amount) throws ApplicationException;
}
