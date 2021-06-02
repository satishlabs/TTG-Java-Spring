package com.client;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.satishlabs.dao.AccountDao;
import com.satishlabs.entity.Account;
import com.satishlabs.exception.DaoException;

public class AccountDaoTest {
	static Logger logger = Logger.getLogger(AccountDaoTest.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	 
		AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
		Account rahulAccount = new Account("SB500", "Rahul Prakash", 45000.55);
		Account gavinAccount = new Account("SB8920", "Gavin king", 6000.33);
		try {
			accountDao.createAccount(rahulAccount);
		} catch (DaoException e) {
			logger.debug(e);
		}
		try {
			accountDao.createAccount(gavinAccount);
		} catch (DaoException e) {
			logger.debug(e);
		}

		
		
		List<Account> accounts;
		try {
			accounts = accountDao.getAllAccounts();
			for (Account account : accounts) {
				System.out.println(account);
			}
		} catch (DaoException e) {
			logger.debug(e);
		}

	}
	}
}	
