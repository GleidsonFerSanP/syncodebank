package com.extra.exceptions;

public class HibernateCustomException extends Exception{

	private static final long serialVersionUID = 1L;

	public HibernateCustomException(String message) {
		super(message);
	}

}
