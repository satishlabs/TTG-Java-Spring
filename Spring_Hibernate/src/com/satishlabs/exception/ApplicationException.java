package com.satishlabs.exception;

public class ApplicationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6093839164664990460L;
	
	public ApplicationException() {
		super();
	}
	
	public ApplicationException(String msg,Throwable ex) {
		super(msg,ex);
	}
	
	public ApplicationException(String msg) {
		super(msg);
	}
	
	public ApplicationException(Throwable ex) {
		super(ex);
	}
}
