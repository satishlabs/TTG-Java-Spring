package com.satishlabs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.satishlabs.entity.Account;
import com.satishlabs.exception.DaoException;

public class AccountDaoHibernateImpl implements AccountDao{
	private HibernateTemplate hibernateTemplate;
	
	public void init(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void createAccount(Account account) throws DaoException {
		try {
			hibernateTemplate.save(account);
		}catch (DataAccessException e) {
			throw new DaoException(e.getMessage(),e);
		}
		
	}

	@Override
	public Account getAccount(String accountNumber) throws DaoException {
		try {
			return hibernateTemplate.get(Account.class, accountNumber);
		}catch (DataAccessException e) {
			throw new DaoException(e.getMessage(),e);
		}
	}

	@Override
	public List<Account> getAllAccounts() throws DaoException {
		try {
			return hibernateTemplate.find("from account");
		}catch (DataAccessException e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	@Override
	public void updateAccount(Account account) throws DaoException {
		try {
			hibernateTemplate.merge(account);
		}catch (StaleObjectStateException e) {
			throw new DaoException("Object is modifed by other user", e);
		}catch (DataAccessException e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
 
}
