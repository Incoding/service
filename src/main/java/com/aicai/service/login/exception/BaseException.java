package com.aicai.service.login.exception;

public class BaseException extends RuntimeException {
	private static final long	serialVersionUID	= 1L;
	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}


}
