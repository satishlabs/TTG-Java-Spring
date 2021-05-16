package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Account;

public class AccountDaoTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Account satishAcc = ctx.getBean("Satish Account : ", Account.class);
		System.out.println(satishAcc.getAccountNumber()+" , "+satishAcc.getAccountOwner()+" , "+satishAcc.getBalance());
	}
}
