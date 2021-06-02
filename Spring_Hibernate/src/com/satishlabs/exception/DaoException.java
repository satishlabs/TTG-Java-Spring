package com.satishlabs.exception;

public class DaoException extends ApplicationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 430808582726449119L;
	
	public DaoException() {
		super();
	}
	
	public DaoException(String msg,Throwable ex) {
		super(msg,ex);
	}
	
	public DaoException(String msg) {
		super(msg);
	}
	
	public DaoException(Throwable ex) {
		super(ex);
	}
}
