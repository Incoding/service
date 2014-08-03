package com.aicai.service.login.exception;

public class DbException extends BaseException {
	private static final long	serialVersionUID	= 1L;
	private static String		message				= "数据库异常";

	public DbException() {
		super();
	}

	public DbException(Throwable cause) {
		super(message, cause);
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
