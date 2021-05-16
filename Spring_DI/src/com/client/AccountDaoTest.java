package com.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AccountDao;
import com.entity.Account;

public class AccountDaoTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Account satishAcc = ctx.getBean("Satish Account : ", Account.class);
		Account dhoniAcc = ctx.getBean("Dhoni Account : ", Account.class);
		AccountDao accountDao = ctx.getBean("AccountDao : ", AccountDao.class);
		
		accountDao.create(satishAcc);
		accountDao.create(dhoniAcc);
		
		List<Account> accounts = accountDao.getAllAccount();
		for(Account account : accounts) {
			System.out.println(account);
		}
	}
}
