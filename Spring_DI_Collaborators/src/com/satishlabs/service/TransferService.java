package com.satishlabs.service;

public interface TransferService {
	/**
	 * @param fromAccount
	 * @param destAccount
	 * @param amount
	 */
	public void transferFunds(String fromAccount,String destAccount,double amount);
}
