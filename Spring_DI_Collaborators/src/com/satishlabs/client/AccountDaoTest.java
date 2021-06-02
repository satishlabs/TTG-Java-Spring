package com.satishlabs.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.satishlabs.dao.AccountDao;
import com.satishlabs.entity.Account;
import com.satishlabs.service.TransferService;

public class AccountDaoTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Account rahulAcc = (Account) ctx.getBean("RahulAccount "+Account.class);
		Account deepaAcc = (Account) ctx.getBean("DeepaAccount "+Account.class);
		AccountDao accountDao = (AccountDao) ctx.getBean("AccountDao "+AccountDao.class);
		
		accountDao.createAccount(rahulAcc);
		accountDao.createAccount(deepaAcc);
		
		
		TransferService transferService = (TransferService) ctx.getBean("TransferService "+TransferService.class);
		transferService.transferFunds("SB500", "SB922", 500.00);
		
		List<Account> accounts = accountDao.getAllAccounts();
		for(Account account : accounts) {
			System.out.println(account);
		}
	}
}
