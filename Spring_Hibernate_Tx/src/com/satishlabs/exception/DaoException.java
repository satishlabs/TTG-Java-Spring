package com.satishlabs.exception;

public class DaoException extends ApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public DaoException() {
		super();
	}
	
	/**
	 * @param msg
	 * @param ex
	 */
	public DaoException(String msg,Throwable ex) {
		super(msg,ex);
	}
	
	/**
	 * @param msg
	 */
	public DaoException(String msg) {
		super(msg);
	}
	
	/**
	 * @param ex
	 */
	public DaoException(Throwable ex) {
		super(ex);
	}
}
