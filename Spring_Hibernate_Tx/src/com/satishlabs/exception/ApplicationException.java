package com.satishlabs.exception;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public ApplicationException() {
		super();
	}
	
	/**
	 * @param msg
	 * @param ex
	 */
	public ApplicationException(String msg,Throwable ex) {
		super(msg,ex);
	}
	
	/**
	 * @param msg
	 */
	public ApplicationException(String msg) {
		super(msg);
	}
	
	/**
	 * @param ex
	 */
	public ApplicationException(Throwable ex) {
		super(ex);
	}
}
