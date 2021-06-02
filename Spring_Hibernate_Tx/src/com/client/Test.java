package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		String[] beans = context.getBeanNamesForType(TransactionProxyFactoryBean.class);
		for(String bean : beans) {
			System.out.println(bean);
		}
	}
}
